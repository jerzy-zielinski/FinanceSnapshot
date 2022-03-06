-- Function: interest_gain(date)

DROP FUNCTION interest_gain(date);

CREATE OR REPLACE FUNCTION interest_gain(date_since date)
RETURNS numeric AS
$BODY$
DECLARE gain_since numeric;
BEGIN
select abs(sum(s.quantity_num)/100)
into gain_since
from splits s 
inner join transactions t on t.guid = s.tx_guid
inner join accounts a on a.guid = s.account_guid 
and (a.name like '%Interest' or a.name like '%Dividends')
and t.post_date > date_since;
RETURN gain_since; 
END;
$BODY$
LANGUAGE plpgsql VOLATILE
COST 100;
ALTER FUNCTION interest_gain(date)
OWNER TO postgres;

