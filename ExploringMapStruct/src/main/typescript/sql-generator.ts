import * as fs from 'fs';

const TEST_DATA_SIZE = 100_000;

const base = `-- DELETE FROM EMPLOYEE_PROJECTS;
DELETE FROM EMPLOYEE;
-- DELETE FROM PROJECT;`

let result = [base];

for (let id = 0; id > -TEST_DATA_SIZE; id--) {
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
