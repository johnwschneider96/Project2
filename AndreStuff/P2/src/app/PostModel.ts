//postid, content, numoflikes, useremail

export class Posting{
    postid: number;
    content: string;
    numoflikes: number;
    useremail: string;

    constructor(postid: number = 0, content: string = '',
    numoflikes: number = 0, useremail: string = ''){
        this.postid = postid;
        this.content = content;
        this.numoflikes = numoflikes;
        this.useremail = useremail;

    }








}