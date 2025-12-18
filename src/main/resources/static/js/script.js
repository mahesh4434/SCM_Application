console.log("Script loaded")

let currentTheme = getTheme();
changeTheme(currentTheme);

function changeTheme() {
    //set to webpage 
    document.querySelector('html').classList.add(currentTheme);

}

//Set theme to local storage 
function setTheme(theme) {
    localStorage.setTheme("theme", theme);
}

console.log(currentTheme);
//Get theme from local storage
function getTheme() {

    let theme = localStorage.getItem("theme");

    return theme ? theme : "light";
}