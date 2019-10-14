function validations(){

    var date1 = document.getElementById("startDate").value;
    var date2 = document.getElementById("endDate").value;

    if(date1 && date2!=""){
        if (date1 >= date2 ){
            alert("Starting date cannot be less or the same as endingDate");
            document.getElementById("startDate").style.borderColor ="red";
            document.getElementById("endDate").style.borderColor ="red";
            return false;
        }
    }

    var currentDate = new Date();
    //daca lasi doar getYear iti da ciudat
    var year = currentDate.getFullYear();
    var month = currentDate.getMonth() +1;
    if(month <=9){
        month = '0'+month;
    }
    var day = currentDate.getDate();
    if(day <=9){
        day ='0'+day;
    }
    var today = year+'-'+month+'-'+day;
    if (date1<today){
        alert("Please enter a valid startDate");
        document.getElementById("startDate").style.borderColor ="red";
        return false;
    }





    var myItem = document.getElementById("name").value;
    if(myItem!==""){
        if(myItem.charAt(0) >='0' && myItem.charAt(0) <= '9')
        {
            alert("Item name cannot start with a number");
            document.getElementById("name").style.borderColor ="red";
            return false;

        }}
    if(myItem !==""){
        if(myItem.charAt(0) == myItem.charAt(0).toLowerCase() && myItem.charAt(1) == myItem.charAt(1).toUpperCase()){
            alert("Item name is not exactly correct");
            document.getElementById("name").style.borderColor= "red";
            return false;
        }}




    else{
        document.getElementById("myForm").style.borderColor = "green";
        document.getElementById("button").submit();

    }

}