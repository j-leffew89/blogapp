import createView from "../createView.js";

export default function PostIndex(props) {
    return `
         <header>
        <h1>Posts Page</h1>
    </header>
    <main>
    <form>
        <input id="title" type="text">
        <input id="content" type="text">
        <button id="create-post-btn" type="button">Add Post</button>
    </form>
        <div>
            ${props.posts.map(post => `
                  <div>
                        <input class="edit-title" contentEditable="false" value="${post.title}">
                        <input class="edit-content" contentEditable="false" value="${post.content}">

                        <button class="edit-btn" data-id="${post.id}">Edit</button>
                        <button class="delete-btn">Delete</button>
                </div>
            `).join('')}
            <!--    add edit, delete buttons, add edit form   -->
        </div>


        <form></form>

        <form>

        </form>
    </main>
    `;
}

export function PostEvents() {

    createEvent()
    editEvent()
    //
    // var postObj = {};
    // var addListener = function (event) {
    //
    //     const title = document.getElementById('input-title').value;
    //     const content = document.getElementById('input-content').value;
    //     const id = document.getElementById('input-id').value;
    //
    //     postObj = {title, content, id}
    //     console.log(postObj);
    // }
    //
    // document.getElementById('add-btn').addEventListener('click', addListener);

}
function createEvent() {
    $("#create-post-btn").click(function (){

        let post = {
            title : $('#title').val(),
            content : $('#content').val()
        }

        let request = {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(post)
        }

        fetch("http://localhost:8080/api/posts", request)
            .then(res => {
                console.log(res.status);
                createView("/posts")
            }).catch(error => {
            console.log(error);
            createView("/posts")
        });
    })
}

function editEvent(){
    $(".edit-btn").click(function (){
        console.log("edit event fired off")

        $(this).siblings(".edit-title, .edit-content").attr("contenteditable", true);
        $(this).text("Save");
    })
}




