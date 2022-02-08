class Company {
    constructor() {
        this.departments = {};
    }

    addEmployee(name, salary, position, department) {
        if (!name || !salary || !position || !department || salary < 0) {
            throw new Error('Invalid input');
        }

        if (!this.departments[department]){
            this.departments[department] = [];
        }

        this.departments[department].push({name , position , salary});

        console.log(`New employee is hired. Name: ${name}. Position: ${position}`)
    }

    bestDepartment() {
        this.departments.sort(department => {
            return this.averageSalary(department)
        })
    }

    averageSalary(department) {
        let sumSalary = 0;
        const countEmployees = this.departments[department].length;
        this.departments[department].forEach(e => sumSalary += e.salary);

        return sumSalary / countEmployees;
    }
}

let c = new Company();
c.addEmployee("Stanimir", 2000, "engineer", "Construction");
c.addEmployee("Pesho", 1500, "electrical engineer", "Construction");
c.addEmployee("Slavi", 500, "dyer", "Construction");
c.addEmployee("Stan", 2000, "architect", "Construction");
c.addEmployee("Stanimir", 1200, "digital marketing manager", "Marketing");
c.addEmployee("Pesho", 1000, "graphical designer", "Marketing");
c.addEmployee("Gosho", 1350, "HR", "Human resources");
console.log(c.bestDepartment());

