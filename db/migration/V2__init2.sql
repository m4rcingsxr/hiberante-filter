INSERT INTO users(id, name, lastname) VALUES (nextval('users_seq'),'John', 'Doe');
INSERT INTO users(id, name, lastname) VALUES (nextval('users_seq'),'Mark', 'ABC');

INSERT INTO address(id, street) VALUES (nextval('address_seq'), 'street1');
INSERT INTO address(id, street) VALUES (nextval('address_seq'), 'road2');