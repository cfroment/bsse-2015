insert into EVALUATOR(ID,FIRST_NAME, LAST_NAME, EMAIL) values (-1, 'Corentin', 'Froment', 'corentin.froment@gmail.com');
insert into EVALUATOR(ID,FIRST_NAME, LAST_NAME, EMAIL) values (-2, 'Maxime', 'Vande Ghinste', 'mvdeghin@gmail.com');

insert into CANDIDATE(ID, FIRST_NAME, LAST_NAME, DESTINATION) values(-1,'John','Doe','Madrid, Spain');
insert into CANDIDATE(ID, FIRST_NAME, LAST_NAME, DESTINATION) values(-2,'Jane','Bar','Helsinki, Finland');

insert into CRITERION(ID, WEIGHT) values(-1, 0.5);
insert into CRITERION(ID, WEIGHT) values(-2, 0.3);
insert into CRITERION(ID, WEIGHT) values(-3, 0.2);

insert into EVALUATION(ID, CRITERION_ID, EVALUATOR_ID, CANDIDATE_ID, SCORE) VALUES(-1, -1, -1, -1, 4);
insert into EVALUATION(ID, CRITERION_ID, EVALUATOR_ID, CANDIDATE_ID, SCORE) VALUES(-2, -2, -1, -1, 4);
insert into EVALUATION(ID, CRITERION_ID, EVALUATOR_ID, CANDIDATE_ID, SCORE) VALUES(-3, -3, -1, -1, 4);

insert into EVALUATION(ID, CRITERION_ID, EVALUATOR_ID, CANDIDATE_ID, SCORE) VALUES(-4, -1, -1, -2, 4);
insert into EVALUATION(ID, CRITERION_ID, EVALUATOR_ID, CANDIDATE_ID, SCORE) VALUES(-5, -2, -1, -2, 3);
insert into EVALUATION(ID, CRITERION_ID, EVALUATOR_ID, CANDIDATE_ID, SCORE) VALUES(-6, -3, -1, -2, 2);

insert into EVALUATION(ID, CRITERION_ID, EVALUATOR_ID, CANDIDATE_ID, SCORE) VALUES(-7, -1, -2, -1, 1);
insert into EVALUATION(ID, CRITERION_ID, EVALUATOR_ID, CANDIDATE_ID, SCORE) VALUES(-8, -2, -2, -1, 3);
insert into EVALUATION(ID, CRITERION_ID, EVALUATOR_ID, CANDIDATE_ID, SCORE) VALUES(-9, -3, -2, -1, 4.5);

insert into CANDIDATE_DOCUMENT(ID, CANDIDATE_ID, DOCUMENT_TYPE, URL) VALUES(-1, -1, 'CV', 'http://bsse.example.com/cv1.pdf');
insert into CANDIDATE_DOCUMENT(ID, CANDIDATE_ID, DOCUMENT_TYPE, URL) VALUES(-2, -1, 'MOTIVATION', 'http://bsse.example.com/motivation1.pdf');

