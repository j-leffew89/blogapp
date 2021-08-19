import createView from "../createView.js";

export default function User(props) {
    return `
         <header>
        <h1>Users Page</h1>
    </header>
    <main>
        <div>
            ${props.users.map(user => `
                  <div>
                  
                           <div class="row g-3">
            <div class="col">
            <input type="text" class="form-control" data-id="" aria-label="First name" value="${user.name}">
            </div>
        </div>
        <div class="row g-3">
            <div class="col">
            <input type="text" class="form-control" placeholder="Username" aria-label="First name">
            </div>
        </div>
        <div class="row g-3">
            <div class="col">
            <input type="text" class="form-control" placeholder="E-mail" aria-label="First name">
            </div>
        </div>
        <div class="row g-3">
            <div class="col">
            <input type="text" class="form-control" placeholder="Password" aria-label="First name">
            </div>
        </div>
            <button type="button" id="edit-btn">Edit</button>
                </div>
            `).join('')}
        </div>
    </main>
    `;
}

export function UserEvent(){

    // $("#edit-btn").click(function () {
    //
    //     console.log("edit event fired off!!");
    //
    //     $().attr("contenteditable", false);
    //     $("#").text("Edit");
    // })
}