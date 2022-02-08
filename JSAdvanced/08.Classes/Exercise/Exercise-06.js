class Company {
    constructor() {
        this.departments = {};
    }

    addEmployee(name, salary, position, department) {
        if (name && salary && salary > 0 && position && department) {
            if (!this.departments[department]) {
                this.departments[department] = [];
            }
            this.departments[department].push({name, salary, position})
            return `New employee is hired. Name: ${name}. Position: ${position}`
        } else {
            throw new Error(`Invalid input!`);
        }
    }

    bestDepartment() {
        let bestDep = '';
        let bestAvgSal = 0;

        for (const department of Object.keys(this.departments)) {
            let total = 0;
            for (const departmentElement of this.departments[department]) {
                total += departmentElement.salary;
            }
            let avgSal = total / this.departments[department].length;
            if (avgSal > bestAvgSal) {
                bestAvgSal = avgSal;
                bestDep = department;
            }
        }

        let output = [];
        output.push(`Best Department is: ${bestDep}`);
        output.push(`Average salary: ${bestAvgSal.toFixed(2)}`)
        this.departments[bestDep]
            .sort((e1, e2) => {
                let result = e2.salary - e1.salary
                if (result === 0){
                    result = e1.name.localeCompare(e2.name);
                }
                return result;
            })
            .forEach(e => output.push(`${e.name} ${(e.salary)} ${e.position}`));

        return output.join('\n');
    }
}

let c = new Company();
// c.addEmployee("Stanimir", 2000, "engineer", "Construction");
// c.addEmployee("Pesho", 1500, "electrical engineer", "Construction");
// c.addEmployee("Slavi", 500, "dyer", "Construction");
// c.addEmployee("Stan", 2000, "architect", "Construction");
// c.addEmployee("Stanimir", 1200, "digital marketing manager", "Marketing");
// c.addEmployee("Pesho", 1000, "graphical designer", "Marketing");
// c.addEmployee("Gosho", 1350, "HR", "Human resources");
// console.log(c.bestDepartment());
c.addEmployee("Stanimir", 2000, "engineer", "Human resources");
c.addEmployee("Pesho", 1500, "electrical engineer", "Construction");
c.addEmployee("Slavi", 500, "dyer", "Construction");
c.addEmployee("Stan", 2000, "architect", "Construction");
c.addEmployee("Stanimir", 1200, "digital marketing manager", "Marketing");
c.addEmployee("Pesho", 1000, "graphical designer", "Marketing");
c.addEmployee("Gosho", 1350, "HR", "Human resources");
console.log(c.bestDepartment());