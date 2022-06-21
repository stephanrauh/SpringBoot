DELETE FROM EMPLOYEE_PROJECTS;
DELETE FROM EMPLOYEE;
INSERT INTO EMPLOYEE(id, first_name, last_name) VALUES (-1, 'Anna', 'Konda');
INSERT INTO EMPLOYEE(id, first_name, last_name) VALUES (-2, 'Anno', 'Nymous');
INSERT INTO EMPLOYEE(id, first_name, last_name) VALUES (-3, 'Beyond', 'Java');

DELETE FROM PROJECT;
INSERT INTO PROJECT(id, name, description) VALUES (-1, 'ngx-extended-pdf-viewer', 'A cute little PDF viewer for Angular.');

INSERT INTO EMPLOYEE_PROJECTS(employee_id, projects_id) VALUES(-3, -1);