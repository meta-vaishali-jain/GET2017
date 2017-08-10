function goToThisPage(pageToGoTo){
  window.location.assign(pageToGoTo);
}


function limitText(limitField, limitNum) {
    if (limitField.value.length > limitNum) {
        limitField.value = limitField.value.substring(0, limitNum);

    }
}

function checkName(Field)
      {

        var inputtxt=document.getElementById('userName').value;

      var letters = "^[A-Za-z ]+$";

      if(inputtxt.match(letters))
      {

        document.getElementById('nameICon').style.display='none';
      document.getElementById(Field).innerHTML="";
      return true;
      }
      else{

    document.getElementById('nameICon').style.display='inline';
        document.getElementById(Field).innerHTML="invalid name";

        document.getElementById('userName').focus();
        return false;
      }
      }

      function checkEmail(Field)
          {

            var inputtxt=document.getElementById('userEmail').value;

          var letters = "^[a-zA-Z0-9._]+@[a-zA-Z]+.[a-zA-Z]{2,3}$";
          if(inputtxt.match(letters))
          {

            document.getElementById('emailICon').style.display='none';
          document.getElementById(Field).innerHTML="";
          return true;
          }
          else
          {

          document.getElementById('emailICon').style.display='inline';
          document.getElementById('emailError').innerHTML="invalid email";

          document.getElementById('userEmail').focus();
          return false;
          }
          }

    function checkCity(Field)
      {
          var selectIndex=document.getElementById('userCity').selectedIndex;
          var inputtxt=document.getElementById('userCity').options;
          if(!inputtxt=="") {
        	 document.getElementById("selectedCity").style.display='block';
           document.getElementById("selectedCity").value ="selected city: " + inputtxt[selectIndex].text;
        	 return true;
         }
      else{
             document.getElementById('userCity').focus();
        	    return false;
           }
         }

  function checkOrganisation(Field)  {
      var inputtxt=document.getElementById('userOrgName').value;
              var letters = "^[A-Za-z ]+$";
              if(inputtxt.match(letters)){
                document.getElementById('orgICon').style.display='none';
                document.getElementById(Field).innerHTML="";
                return true;
              }
              else{
                  document.getElementById('orgICon').style.display='inline';
                  document.getElementById(Field).innerHTML="invalid organisation name";
                  document.getElementById('userOrgName').focus();
                  return false;
                  }
              }

    function checkContact(Field)
            {
              var inputtxt=document.getElementById('userContactNo').value;
              var letters = /^[7-9][0-9]{9}$/;
              if(inputtxt.match(letters)){
                document.getElementById('contactICon').style.display='none';
                document.getElementById(Field).innerHTML="";
                return true;
              }
              else{
                document.getElementById('contactICon').style.display='inline';
                document.getElementById(Field).innerHTML="invalid contact number";
                document.getElementById('userContactNo').focus();
                return false;
              }
            }
