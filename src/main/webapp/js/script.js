function validate() {
    if(nameValidation() && emailValidation() && yearValidation() && courseValidation()) {
        alert("Form submitted successfully!");
        return true; // allow form submission
    } else {
        alert("Please fill out all fields correctly.");
    }
    return false;
}

function courseValidation() {
    let course = document.getElementById("course").value;
    return course !== ""; // false if placeholder option is selected
}

function nameValidation() {
    let name = document.getElementById("name").value.trim();

        if(!name)                          return false; // empty
        if(!/^[a-zA-Z ]+$/.test(name))    return false; // invalid chars
        if(name.length > 16)               return false; // too long

        return true;
 }

 function emailValidation() {
        let email = document.getElementById("email").value.trim();
        if(!email) return false; // empty
        if(!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email)) return false; // invalid format

        return true;
 }

 function yearValidation() {
     let year = document.getElementById("year").value.trim();
     if(!year) return false; // empty
     if(!/^\d{4}$/.test(year)) return false; // not 4 digits
     let yearNum = parseInt(year, 10);
     if(yearNum < 1900 || yearNum > new Date().getFullYear()) return false; // out of range

     return true;
 }