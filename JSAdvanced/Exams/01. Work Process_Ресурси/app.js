function solve() {
    let fnameInputElement = document.getElementById('fname');
    let lnameInputElement = document.getElementById('lname');
    let emailInputElement = document.getElementById('email');
    let birthInputElement = document.getElementById('birth');
    let positionInputElement = document.getElementById('position');
    let salaryInputElement = document.getElementById('salary')
    let hireWorkerButton = document.getElementById('add-worker');
    let tbodyElement = document.getElementById('tbody');
    let sumSpanElement = document.getElementById('sum');

    hireWorkerButton.addEventListener('click' , addWorker);

    function addWorker(ev){
        ev.preventDefault();
        let fname = fnameInputElement.value.trim();
        let lname = lnameInputElement.value.trim();
        let email = emailInputElement.value.trim();
        let birth = birthInputElement.value.trim();
        let position = positionInputElement.value.trim();
        let salary = salaryInputElement.value.trim();

        if (fname && lname && email && birth && position && salary){
            let trElement = document.createElement('tr');

            let fnameTdElement = document.createElement('td');
            fnameTdElement.textContent = fname;
            trElement.appendChild(fnameTdElement);

            let lnameTdElement = document.createElement('td');
            lnameTdElement.textContent = lname;
            trElement.appendChild(lnameTdElement);

            let emailTdElement = document.createElement('td');
            emailTdElement.textContent = email;
            trElement.appendChild(emailTdElement);

            let birthTdElement = document.createElement('td');
            birthTdElement.textContent = birth;
            trElement.appendChild(birthTdElement);

            let positionTdElement = document.createElement('td');
            positionTdElement.textContent = position;
            trElement.appendChild(positionTdElement);

            let salaryTdElement = document.createElement('td');
            salaryTdElement.textContent = salary;
            trElement.appendChild(salaryTdElement);

            let buttonsElement = document.createElement('td');

            let firedButton = document.createElement('button');
            firedButton.className = 'fired';
            firedButton.textContent = 'Fired';
            firedButton.addEventListener('click' , fired)
            buttonsElement.appendChild(firedButton);

            let editButton = document.createElement('button');
            editButton.className = 'edit';
            editButton.textContent = 'Edit';
            editButton.addEventListener('click' , edit)
            buttonsElement.appendChild(editButton);

            trElement.appendChild(buttonsElement);

            tbodyElement.appendChild(trElement);

            let currentSum = Number(sumSpanElement.textContent);
            sumSpanElement.textContent = (currentSum + Number(salary)).toFixed(2);

            function fired(ev){
                let employeeElement = ev.target.parentElement.parentElement;
                let params = Array.from(employeeElement.children);

                const salary = params[5].textContent;

                let currentSum = Number(sumSpanElement.textContent);
                sumSpanElement.textContent = (currentSum - Number(salary)).toFixed(2);

                employeeElement.remove();
            }

            function edit(ev){
                let employeeElement = ev.target.parentElement.parentElement;
                let params = Array.from(employeeElement.children);

                const fname = params[0].textContent;
                const lname = params[1].textContent;
                const email = params[2].textContent;
                const birth = params[3].textContent;
                const position = params[4].textContent;
                const salary = params[5].textContent;

                fnameInputElement.value = fname;
                lnameInputElement.value = lname;
                emailInputElement.value = email;
                birthInputElement.value = birth;
                positionInputElement.value = position;
                salaryInputElement.value = salary;

                let currentSum = Number(sumSpanElement.textContent);
                sumSpanElement.textContent = (currentSum - Number(salary)).toFixed(2);

                employeeElement.remove();
            }
        }

        fnameInputElement.value = '';
        lnameInputElement.value = '';
        emailInputElement.value = '';
        birthInputElement.value = '';
        positionInputElement.value = '';
        salaryInputElement.value = '';
    }
}
solve()