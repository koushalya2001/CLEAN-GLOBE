/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function myFunction(e){
         var om= e.target.id+"text"
         document.getElementById(om).innerText=e.target.value
         var shipList = document.getElementById(e.target.id);
         shipList.options[shipList.selectedIndex].remove();
        }