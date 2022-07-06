import * as fs from 'fs';

const TEST_DATA_SIZE = 100_000;

const base = `DELETE FROM EMPLOYEE_PROJECTS;
DELETE FROM EMPLOYEE;
INSERT INTO EMPLOYEE(id, first_name, last_name) VALUES (-1, 'Anna', 'Konda');
INSERT INTO EMPLOYEE(id, first_name, last_name) VALUES (-2, 'Anno', 'Nymous');
INSERT INTO EMPLOYEE(id, first_name, last_name) VALUES (-3, 'Beyond', 'Java');

DELETE FROM PROJECT;
INSERT INTO PROJECT(id, name, description) VALUES (-1, 'ngx-extended-pdf-viewer', 'A cute little PDF viewer for Angular.');

INSERT INTO EMPLOYEE_PROJECTS(employee_id, projects_id) VALUES(-3, -1);`

let result = [base];

for (let id = -4; id > -TEST_DATA_SIZE; id--) {
    let sql = `INSERT INTO EMPLOYEE(id, first_name, last_name) VALUES (${id}, 'Em Ploy', 'Yee${id}');`;
    result.push(sql);
}
/*
for (let id = 0; id > -1_000_00; id--) {
    let sql = `INSERT INTO PROJECT(id, name, description) VALUES (${id}, 'ngx-extended-pdf-viewer${id}', 'A cute little PDF viewer for Angular.${id}');`;
    result.push(sql);
}
for (let id = -1; id > -1_000_00; id--) {
    let sql = `INSERT INTO EMPLOYEE_PROJECTS(employee_id, projects_id) VALUES (${id%100_00}, ${id});`;
    result.push(sql);
}
 */
fs.writeFileSync('../resources/data.sql', result.join("\n"));
