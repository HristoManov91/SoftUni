export const animalIsInvalid = (animalData) => {
    const requiredFields = ['name' , 'breed' , 'age' , 'weight' , 'image'];

    return requiredFields.some(x => !animalData[x]);
}