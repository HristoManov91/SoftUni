export const saveUser = (user) => {
    if (user.accessToken) {
        localStorage.setItem('user', JSON.stringify(user))
    }
};

export const getUser = () => {
    let serializedUser = localStorage.getItem('user');

    if (serializedUser) {
        return JSON.parse(serializedUser);
    }
};

export const clearUser = () => {
    localStorage.removeItem('user');
}

export const getToken = () => {
    return getUser()?.accessToken;
}
