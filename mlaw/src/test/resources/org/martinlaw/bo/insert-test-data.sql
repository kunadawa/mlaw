-- insert test data

insert into martinlaw_court_case_t 
(court_case_id,local_reference, court_reference, status_id, name) 
values 
(1001,'l1', 'c1',1002,"Barca vs Man U (2011)");

insert into
martinlaw_convey_type_t
(convey_type_id, name, description, ver_nbr, obj_id)
values
(1001, "Sale of Urban Land", null, default, 1),
(1002, "Sale of Motor Vehicle", null, default, 1);

insert into martinlaw_convey_t 
(conveyance_id, local_reference, status_id, name, convey_type_id) 
values 
(1001, 'c1', 1001, "Sale of LR4589", 1001);

insert into martinlaw_court_case_client_t (court_case_client_id,court_case_id, principal_name) values (1001, 1001, 'client1');

insert into martinlaw_court_case_witness_t (court_case_witness_id,court_case_id, principal_name) values (1001, 1001, 'witness1');

insert into martinlaw_convey_client_t (convey_client_id, conveyance_id, principal_name) values (1001, 1001, 'client2');

 insert into 
 martinlaw_court_case_hearing_date_t 
 (court_case_hearing_date_id, hearing_date, date_comment, court_case_id, ver_nbr, obj_id) 
 values 
 (1001, '2011-06-01','first hearing date', 1001, default, 1);

insert into
martinlaw_court_case_fee_t
(court_case_fee_id,court_case_id,amount,date_received,description, ver_nbr, obj_id)
values
(1001,1001,2500.58,'2011-06-12','received from karateka', default, 1),
(1002,1001,10000.00,'2010-08-10','received from artist', default, 1);

insert into
martinlaw_convey_fee_t
(convey_fee_id,conveyance_id,amount,date_received,description, ver_nbr, obj_id)
values
(1001,1001,2500.58,'2011-06-12','received from karateka', default, 1);

insert into
martinlaw_convey_annex_type_t
(convey_annex_type_id, convey_type_id, name, description, ver_nbr, obj_id)
values
(1001, 1001, "land board approval", null, default, 1),
(1002, 1001, "city council approval", null, default, 1),
(1003, 1002, "sale agreement", null, default, 1);

insert into
martinlaw_convey_annex_t
(convey_annex_id, convey_annex_type_id, conveyance_id, ver_nbr, obj_id)
values
(1001, 1001, 1001, default, 1);

insert into
martinlaw_convey_att_t
(convey_att_id, att_id, convey_annex_id, ver_nbr, obj_id)
values
(1001, 1001, 1001, default, 1);