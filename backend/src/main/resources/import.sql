INSERT INTO tb_company(name, address, address_number, address_complement, cnpj) VALUES ('IBM', 'Rua Tutóia', 1157, 'Vila Mariana', '84.614.506/0001-80');
INSERT INTO tb_company(name, address, address_number, address_complement, cnpj) VALUES ('Google', 'Av.Brigadeiro Faria Lima', 3477, 'Andares 17 ao 20 na Torre Sul', '76.687.469/0001-02');
INSERT INTO tb_company(name, address, address_number, address_complement, cnpj) VALUES ('Facebook', 'R. Leopoldo Couto de Magalhães Júnior', 700, 'Vila Mariana', '42.524.070/0001-99');
INSERT INTO tb_company(name, address, address_number, address_complement, cnpj) VALUES ('Amazon', 'Alameda dos Nhambiquaras - Moema, São Paulo - SP, 04090-003',  1770 , '', '51.720.531/0001-90');


INSERT INTO tb_user (name,email, password, company_id) VALUES ('Alex Brown','alex@gmail.com', '123456',1);
INSERT INTO tb_user (name,email, password, company_id) VALUES ('Maria Green', 'maria@gmail.com', '123456',2);
INSERT INTO tb_user (name,email, password, company_id) VALUES ('Bob Red', 'bob@gmail.com', '123456',1);

INSERT INTO tb_role (authority) VALUES ('ROLE_STUDENT');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 1);


INSERT INTO tb_area(name)VALUES('UX');
INSERT INTO tb_area(name)VALUES('Design');
INSERT INTO tb_area(name)VALUES('Desenvolvimento BackEnd');
INSERT INTO tb_area(name)VALUES('Desenvolvimento FrontEnd');
INSERT INTO tb_area(name)VALUES('Desenvolvimento Mobile');
INSERT INTO tb_area(name)VALUES('DevOps');
INSERT INTO tb_area(name)VALUES('Machine Learning');
INSERT INTO tb_area(name)VALUES('IA');

INSERT INTO tb_course(name, area_id)VALUES ('Introdução à UX', 1);
INSERT INTO tb_course(name, area_id)VALUES ('Gerando Entregáveis', 1);
INSERT INTO tb_course(name, area_id)VALUES ('Design Thinking: Inovação e Criatividade', 2 );
INSERT INTO tb_course(name, area_id)VALUES ('Trabalhando na Construção de um Design System',2 );
INSERT INTO tb_course(name, area_id)VALUES ('Java e JPA: Pesquise seus objetos com a JPA2 e Hibernate', 3);
INSERT INTO tb_course(name, area_id)VALUES ('Java e JPA: Pesquise com JPQL e Criteria', 3);
INSERT INTO tb_course(name, area_id)VALUES ('React: Entendendo como a biblioteca funciona', 4);
INSERT INTO tb_course(name, area_id)VALUES ('React: Ciclo de vida dos componentes', 4);
INSERT INTO tb_course(name, area_id)VALUES ('Curso React Native com Expo: Design System no seu app', 5);
INSERT INTO tb_course(name, area_id)VALUES ('Curso React Native com Expo: Navegação com menu e suporte às telas', 5);
INSERT INTO tb_course(name, area_id)VALUES ('Vagrant: Gerenciando máquinas virtuais', 6);
INSERT INTO tb_course(name, area_id)VALUES ('Docker: Criando containers sem dor de cabeça ', 6);
INSERT INTO tb_course(name, area_id)VALUES ('Machine Learning: Classificação por trás dos panos', 7);
INSERT INTO tb_course(name, area_id)VALUES ('Machine Learning: Lidando com dados de muitas dimensões', 7);
INSERT INTO tb_course(name, area_id)VALUES ('Introduction to AI - IBM', 8);
INSERT INTO tb_course(name, area_id)VALUES ('Artificial Intelligence - MIT', 8);

INSERT INTO tb_enrollment(user_id, course_id, enroll_Moment, refund_Moment, available, only_update) VALUES (1, 1, '2021-03-13T13:00:00', null, true, false);
INSERT INTO tb_enrollment(user_id, course_id, enroll_Moment, refund_Moment, available, only_update) VALUES (2, 1, '2021-03-13T13:00:00', null, true, false);
