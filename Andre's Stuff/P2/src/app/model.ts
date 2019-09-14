export class User{
    password: string;
    firstname: string;
    lastname: string;
    phonenumber: string;
    filename: string;
    email: string;


constructor(password = '', firstname ='', lastname = '',
phonenumber ='', filename = '', email=''){

    this.password = password;
    this.firstname = firstname;
    this.lastname = lastname;
    this.phonenumber = phonenumber;
    this.filename = filename;
    this.email = email;
}

}