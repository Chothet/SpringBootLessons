insert into user_details(id, birth_date,name)
    values(1, current_date, 'Cho Thet');

insert into user_details(id, birth_date,name)
    values(2, current_date, 'Ya Mone');

insert into user_details(id, birth_date,name)
    values(3, current_date, 'K Thi Khaing');

insert into post(id, description, user_id)
    values(1,'I am K Thi Khaing', 3);

insert into post(id, description, user_id)
    values(2,'I am Cho Thet', 1);

insert into post(id, description, user_id)
    values(3,'I am Ya Mone', 2);