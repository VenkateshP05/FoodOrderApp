
 const url = "http://localhost:6601/menu";
 const menuItems = new Object();

fetch(url, {
  method : "GET"
  })
    .then(menu => {return menu.json()})
    .then(menu => {
        menu.forEach(item => {
          menuItems[item.itemName] = item.cost;
          const itemDetails =
          `<tr><td>${item.itemName}</td>
          <td>${item.cost}</td></tr>`;
          document.querySelector("table").insertAdjacentHTML("beforeend",itemDetails);
    })
  });
  console.log(menuItems);
// let incBtn = document.querySelector("#incBtn");
// incBtn.addEventListener("click",increaseCount) ;

// function increaseCount(e){
//   e.preventDefault();
//   let qtt = document.querySelector("#quantity");
//   qtt.value= Number(qtt.value) +1;
// }


// let decBtn = document.querySelector("#decBtn");
// decBtn.addEventListener("click",decreaseCount);

// function decreaseCount(e){
//   e.preventDefault();
//   let qtt = document.querySelector("#quantity");
//   if(Number(qtt.value) >0)
//   qtt.value = Number(qtt.value) -1;
// }


let addBtn = document.getElementById("addBtn");
addBtn.addEventListener("click",addItem);

let placeBtn = document.getElementById("placeOrder");
placeBtn.addEventListener("click",generateBill);

const order = new Object();
const bill = new Object();

function addItem(event){
  event.preventDefault();
  const itemName = document.querySelector('#ItemName');
  const qtt = document.querySelector("#quantity");
  if(qtt.value<=0 || itemName.value == ""){
    alert("invalid item name or quantity");
  }
  else{
    order[itemName.value] = qtt.value;
    addItemsToList(itemName, qtt);
  
    itemName.value = "";
    qtt.value = "0";
    console.log(order);

  }
}

function addItemsToList(itemName, qtt){
  let list = document.getElementById("list");
  let listItems = `<li> ${itemName.value}  x${qtt.value}</li>`;
  list.insertAdjacentHTML("beforeend", listItems);
}

function generateBill(event){
  let total = 0;
  Object.keys(order).forEach(item =>{
    let str = item + "  x"+ order[item];
    console.log(order[item]);
    bill[str] = Number(menuItems[item])*Number(order[item]);
    total += bill[str];
  });
  document.getElementsByTagName("body").insertAdjacentHTML("beforeend",`<p>${total}</p>`);

}