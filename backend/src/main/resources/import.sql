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

INSERT INTO tb_course(name, area_id, img_url)VALUES ('Introdução à UX', 1,'https://cdni.iconscout.com/illustration/free/thumb/upload-image-ui-2043035-1731294.png');
INSERT INTO tb_course(name, area_id, img_url)VALUES ('Gerando Entregáveis', 1,'https://cdn.pixabay.com/photo/2016/04/15/18/05/computer-1331579__340.png');
INSERT INTO tb_course(name, area_id, img_url)VALUES ('Design Thinking: Inovação e Criatividade', 2, 'https://cdn.pixabay.com/photo/2018/08/19/12/34/positive-thinking-3616556_1280.png');
INSERT INTO tb_course(name, area_id, img_url)VALUES ('Trabalhando na Construção de um Design System',2,'https://cdn.iconscout.com/icon/free/png-512/creativity-172-917032.png' );
INSERT INTO tb_course(name, area_id, img_url)VALUES ('Java e JPA: Pesquise seus objetos com a JPA2 e Hibernate', 3,'https://lh3.googleusercontent.com/proxy/L9AHKkg4OQEfUeqmHBwNgq_KiXI3FOF1PRimutSEmPaoD3Sfhf4HAlEeoJGA9KWoJyxogyZThbtaasPzcvVH0VS3G-GhwPdCd8o');
INSERT INTO tb_course(name, area_id, img_url)VALUES ('Java e JPA: Pesquise com JPQL e Criteria', 3, 'data:image/png;base64,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');
INSERT INTO tb_course(name, area_id, img_url)VALUES ('React: Entendendo como a biblioteca funciona', 4, 'https://icons-for-free.com/iconfiles/png/512/logo+react+react+js+icon-1320184811840217251.png');
INSERT INTO tb_course(name, area_id, img_url)VALUES ('React: Ciclo de vida dos componentes', 4, 'https://hermes.digitalinnovation.one/courses/badge/13c558ea-8c4a-4734-b4e5-204954fd9f5b.png');
INSERT INTO tb_course(name, area_id, img_url)VALUES ('Curso React Native com Expo: Design System no seu app', 5, 'https://d2eip9sf3oo6c2.cloudfront.net/playlists/square_covers/000/432/574/square_480/course_image.png');
INSERT INTO tb_course(name, area_id, img_url)VALUES ('Curso React Native com Expo: Navegação com menu e suporte às telas', 5, 'https://5.imimg.com/data5/FL/OJ/DC/GLADMIN-8159280/react-native-app-development-300x300-250x250.png');
INSERT INTO tb_course(name, area_id, img_url)VALUES ('Vagrant: Gerenciando máquinas virtuais', 6, 'https://raw.githubusercontent.com/github/explore/80688e429a7d4ef2fca1e82350fe8e3517d3494d/topics/vagrant/vagrant.png');
INSERT INTO tb_course(name, area_id, img_url)VALUES ('Docker: Criando containers sem dor de cabeça ', 6, 'https://sretips.com.br/images/docker/docker.png');
INSERT INTO tb_course(name, area_id, img_url)VALUES ('Machine Learning: Classificação por trás dos panos', 7,'https://path.com.br/wp-content/uploads/elementor/thumbs/Sem-T%C3%ADtulo-1_Prancheta-1-3-os6pnkee5xcvznjtzggtj380bsb3o736u55da0nqeo.png');
INSERT INTO tb_course(name, area_id, img_url)VALUES ('Machine Learning: Lidando com dados de muitas dimensões', 7,'https://www.ovhcloud.com/sites/default/files/styles/square_small/public/2020-08/UseCase_OVHcloud-dedicated-servers-for-AI-and-machine-learning%402x.png');
INSERT INTO tb_course(name, area_id, img_url)VALUES ('Introduction to AI - IBM', 8, 'https://media-exp1.licdn.com/dms/image/C4E12AQFA9ZpG4dLMRQ/article-inline_image-shrink_1000_1488/0/1537319507030?e=1627516800&v=beta&t=KQhjC8yyPJILIvJ4fuhwlwTdjz2AKWHStv4QvvLML00');
INSERT INTO tb_course(name, area_id, img_url)VALUES ('Artificial Intelligence - MIT', 8,'https://i1.wp.com/blog.sysfore.com/wp-content/uploads/2014/12/Machine-Learning.png');

INSERT INTO tb_enrollment(user_id, course_id, enroll_Moment, refund_Moment, available, only_update) VALUES (1, 1, '2021-03-13T13:00:00', null, true, false);
INSERT INTO tb_enrollment(user_id, course_id, enroll_Moment, refund_Moment, available, only_update) VALUES (2, 1, '2021-03-13T13:00:00', null, true, false);

INSERT INTO tb_study_plan(description, end_date, start_date) VALUES ('Plano de Estudos I','2021-07-13T13:00:00', '2021-04-13T13:00:00' );
INSERT INTO tb_study_plan(description, end_date, start_date) VALUES ('Plano de Estudos II','2021-08-13T13:00:00', '2021-05-13T13:00:00' );
INSERT INTO tb_study_plan(description, end_date, start_date) VALUES ('Plano de Estudos III','2021-09-13T13:00:00', '2021-06-13T13:00:00' );
INSERT INTO tb_study_plan(description, end_date, start_date) VALUES ('Plano de Estudos IV','2021-10-13T13:00:00', '2021-07-13T13:00:00' );
INSERT INTO tb_study_plan(description, end_date, start_date) VALUES ('Plano de Estudos V','2021-11-13T13:00:00', '2021-08-13T13:00:00' );

INSERT INTO tb_study_plan_course(study_plan_id, course_id)VALUES(1,1);
INSERT INTO tb_study_plan_course(study_plan_id, course_id)VALUES(1,2);
INSERT INTO tb_study_plan_course(study_plan_id, course_id)VALUES(2,1);
INSERT INTO tb_study_plan_course(study_plan_id, course_id)VALUES(2,2);
INSERT INTO tb_study_plan_course(study_plan_id, course_id)VALUES(3,3);
INSERT INTO tb_study_plan_course(study_plan_id, course_id)VALUES(3,4);
INSERT INTO tb_study_plan_course(study_plan_id, course_id)VALUES(4,1);
INSERT INTO tb_study_plan_course(study_plan_id, course_id)VALUES(4,3);
INSERT INTO tb_study_plan_course(study_plan_id, course_id)VALUES(5,2);
INSERT INTO tb_study_plan_course(study_plan_id, course_id)VALUES(5,4);

INSERT INTO tb_teacher(name, address, address_number, address_complement, course_id) VALUES('Gustavo Tiago da Silva', 'Rua A', 1234, '',1);
INSERT INTO tb_teacher(name, address, address_number, address_complement, course_id) VALUES('Gabriel Sousa Costa', 'Rua B', 4321, '',2);
INSERT INTO tb_teacher(name, address, address_number, address_complement, course_id) VALUES('João Pereira Silva', 'Rua C', 3456, '',5);
INSERT INTO tb_teacher(name, address, address_number, address_complement, course_id) VALUES('Letícia Silva Sousa', 'Rua D', 0900, '',8);
INSERT INTO tb_teacher(name, address, address_number, address_complement, course_id) VALUES('Francisco Silva', 'Rua E', 9872, '',7);
INSERT INTO tb_teacher(name, address, address_number, address_complement, course_id) VALUES('Gabriel Pereira Júnior', 'Rua F', 9853, '',6);
INSERT INTO tb_teacher(name, address, address_number, address_complement, course_id) VALUES('Carlos Alberto Costa', 'Rua G', 2587, '',1);
INSERT INTO tb_teacher(name, address, address_number, address_complement, course_id) VALUES('Marcelo Silva Santos', 'Rua H', 9854, '',2);
INSERT INTO tb_teacher(name, address, address_number, address_complement, course_id) VALUES('Paulo Silva Santos', 'Rua I', 5236, '',4);
INSERT INTO tb_teacher(name, address, address_number, address_complement, course_id) VALUES('Luiz da Silva', 'Rua J', 2345, '',3);
