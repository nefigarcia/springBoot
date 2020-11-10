
var ho=document.getElementById("tabinicio");
var cur=document.getElementById("tabcursos");
var ta,taa,ta2=0;
function ini(){
    this.ho.style.display="block";
    this.cur.style.display="none";
    
}
function curs() {
        this.cur.style.display="block";
        this.ho.style.display="none";
}

function dista(id){
    if(this.ta2>0){  
        this.taa=this.ta;
    this.taa.style.display="none";
    console.log(this.ta2); 
}

   this.ta= document.getElementById("ta"+id);
    this.ta.style.display="block";
    this.ta2++;
}
//post button
$(document).ready(()=>{
    $("#btngu").click((event)=>{
      //  event.preventDefault();
        console.log("skdfjls");
        doAjax();
    });
});
$(document).ready(()=>{
    $("#pru").click((event)=>{
        alert("skjdflskfjslkdfjskfjkd");
    });
});
function doAjax(){
    var form=$('#formarch')[0];
    var data=new FormData(form);

    $.ajax({
        type:"POST",
        enctype:'multipart/form-data',
        url:"/listActivi",
        data:data,
        success:(data)=>{
           $('#msg').html("ksjdflsd");
         console.log("ksdjfsld");
        }
    })
    
}

