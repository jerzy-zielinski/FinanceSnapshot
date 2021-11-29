-- Function: us_total_proc()

-- DROP FUNCTION us_total_proc();

CREATE OR REPLACE FUNCTION us_total_proc()
RETURNS numeric AS
$BODY$
DECLARE us_total numeric;
BEGIN
with recursive us_assets_tree as
(
select guid, parent_guid, name, account_type from accounts where parent_guid = '42cbb416d45c4542bd5639feec1664f8' 
union all 
select a.guid, a.parent_guid, a.name, a.account_type from us_assets_tree p join accounts a on a.parent_guid = p.guid
)
select sum(quantity_num::decimal/quantity_denom) into us_total
from us_assets_tree a
inner join splits s on s.account_guid = a.guid;
RETURN us_total;
END; $BODY$
LANGUAGE plpgsql VOLATILE
COST 100;
ALTER FUNCTION us_total_proc()
OWNER TO postgres;
