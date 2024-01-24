console.log("FileManager");


{/* <div class="input-group">
<input class="form-control" type="file" name="attachs">
<span class="input-group-text text-danger" >X</span>
</div>	 */}

//javascript
//======================================================
// let filelist = document.getElementById("filelist");
// let fileAdd = document.getElementById("fileAdd");
// let ctncheck = 0;
// fileAdd.addEventListener("click", ()=>{
//     ctncheck++;
//     console.log(ctncheck);
//     if(ctncheck>=6){
//         alert("최대 갯수 5개");
//         div1.remove();
//     }

// let div1 = document.createElement("div");  // <div>
// let class1 = document.createAttribute("class"); // <div class=>

// class1.value="input-group my-2";  // class= "input-group"
// div1.setAttributeNode(class1);
// console.log(div1);

// // ==============================================
// let input2 = document.createElement("input");  // <input>
// let class2 = document.createAttribute("class"); // <input class=>
// let file1 = document.createAttribute("type"); // <input type=>
// let name1 = document.createAttribute("name"); // <input name=>


// class2.value="form-control";
// file1.value="file";
// name1.value="attachs"
// input2.setAttributeNode(class2);
// input2.setAttributeNode(file1);
// input2.setAttributeNode(name1);
// console.log(input2);

// //=================================================
// let span1 = document.createElement("span");
// let class3 = document.createAttribute("class"); // <input class=>
// class3.value="input-group-text text-danger del";
// let t = document.createTextNode("X");
// span1.appendChild(t);
// span1.setAttributeNode(class3);
// div1.appendChild(input2)
// div1.appendChild(span1)
// filelist.appendChild(div1);

// });



//jquery
let ctncheck = 0;
max = $("#filelist").attr('.data-file-max');
console.log(max);
$("#fileAdd").click(()=>{

//     // let element = '<div class="input-group">';
//     // element+= '<input class="form-control" type="file" name="attachs">';
//     // element+='<span class="input-group-text text-danger" >X</span>';
//     // element+='</div>';
//     // $("#filelist").append(element);
    ctncheck++;
    if(ctncheck>=6){
        alert("최대 5개임");
        $(element).remove();
    }
    let element =`<div class="input-group">
    <input class="form-control" type="file" name="attachs">
    <span class="input-group-text text-danger del" >X</span>
    </div>`
    $("#filelist").append(element);
});


//$('.del').click()
$('.del').on("click", function(){
    alert("del");
});
