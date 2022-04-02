import * as animalService from '../services/animalService.js';

export const deleteView = async (ctx) => {
    try {
        const animal = await animalService.getAnimal(ctx.params.animalId);

        let confirmed = confirm(`Do you want to delete the pet: ${animal.name}`);

        if (confirmed) {
            await animalService.remove(animal._id);
            ctx.page.redirect('/dashboard');
        }
    } catch (err) {
        alert(err);
    }
};