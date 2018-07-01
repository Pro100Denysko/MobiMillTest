# MobiMill Test

Simply rest-app, using Java 8, Spring Boot, Spring Data.

Database diagram:

company:

| id     |name        |
| ------ |:----------:|
| 1      | company1   |
| 2      | company1   |
| 3      | company3   |
| 4      | company4   |

company_departments:

| company_id    |department_id |
| --------------|:------------:|
| 1             | 1            |
| 2             | 1            |
| 2             | 2            |
| 2             | 2            |
| 2             | 4            |

department:

| id     |name             |
| ------ |:---------------:|
| 1      | Department A    |
| 2      | Department B    |
| 3      | Department C    |
| 4      | Department D    |
| 5      | Department E    |

position:

| id     |name             |
| ------ |:---------------:|
| 1      | Junior SE       |
| 2      | Middle SE       |
| 3      | Senior SE       |
| 4      | Junior HR       |
| 5      | Middle HR       |
| 5      | Senior HR       |
| 5      | Junior Sales    |
| 5      | Middle Sales    |
| 5      | Senior Sales    |
| 5      | Junior Financier|
| 5      | Middle Financier|
| 5      | Senior Financier|

user_departments:

| user_id    |department_id |
| --------------|:------------:|
| 1             | 1            |
| 1             | 2            |
| 2             | 2            |
| 2             | 3            |
| 2             | 4            |

users:

| id     |name      |lastname    |date_od_birth |position_id |company_id |
| ------ |:--------:|:----------:|:------------:|:----------:|:---------:|
| 1      | Max      |Kolpachev   |1990-05-23    |2           |1          |
| 2      | Andrey   |Molchanov   |1980-12-17    |3           |1          |
| 3      | Sasha    |Borisov     |1985-08-02    |4           |2          |
| 4      | Daria    |Alexeevna   |1995-11-15    |8           |3          |
| 5      | Yulia    |Enicheva    |1991-01-09    |9           |3          |
| 5      | Anton    |Verbovskii  |1987-08-10    |11          |3          |

## CompanyController


Get all companies:
##### Request Method - GET
`http://localhost:8080/api/companies`


Add company:
##### Request Method - POST
`http://localhost:8080/api/company`

Body:
```json
{
        "name": "newCompany",
        "departments": [
             {
                "id": 2,
                "name": "Department B ",
                "companies": null
            },
            {
                "id": 1,
                "name": "Department A",
                "companies": null
            }
        ]
}
```


Delete company:
##### Request Method - DELETE
`http://localhost:8080/api/company/{id}`


Update name:
##### Request Method - PUT
`http://localhost:8080/api/company/{id}?name=newCompanyName`

## UserController


Add user:
##### Request Method - POST
`http://localhost:8080/api/users`

Body:
```json
{
    "name": "name",
    "lastname": "lastname",
    "dateOfBirth": 345852000000,
    "position": {
        "id": 3,
        "name": "Senior SE",
        "user": null
    },
    "company":
    	{
    	"id":1
    	}
}
```


Delete user:
##### Request Method - DELETE
`http://localhost:8080/api/users/{id}`


Update name:
##### Request Method - PUT
`http://localhost:8080/api/users/{id}?name=newName`

## DepartmentController

**All methods are deprecated**


Add department to company:
##### Request Method - POST
`http://localhost:8080/api/company/{id}/departments/{depId}`


Delete department from company:
##### Request Method - POST
`http://localhost:8080/api/delete/company/{id}/departments/{depId}`


Add new user to department:
##### Request Method - POST
`http://localhost:8080/api/users/{id}/departments/{depId}`