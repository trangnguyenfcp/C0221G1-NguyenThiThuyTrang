
select C.customer_name, count(Con.customer_id) as number_of_bookings from customer C
join contract Con on C.customer_id = Con.customer_id
join customer_type CT on C.customer_type_id = CT.customer_type_id 
where customer_type_name = 'Diamond'
group by Con.customer_id;

select C.customer_id, C.customer_name, CT.customer_type_name, Con.contract_id, S.service_name, Con.contract_start_date, Con.contract_end_date, sum(S.service_cost+ATT.attach_service_cost*CD.quantity) AS total_price
from customer C left join customer_type CT on C.customer_type_id = CT.customer_type_id
left join contract Con on C.customer_id = Con.customer_id
left join service S on S.service_id = Con.service_id
left join contract_detail CD on Con.contract_id = CD.contract_id
left join attach_service ATT on ATT.attach_service_id = CD.attach_service_id
group by C.customer_id, Con.contract_id;
