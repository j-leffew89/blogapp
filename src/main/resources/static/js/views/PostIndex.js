import createView from "../createView.js";
import {getHeaders} from "../auth.js";

export default function PostIndex(props) {
    console.log(props)
    return `
         <header>
        <h1>Posts Page</h1>
    </header>
    <main>
    <form>
        <input id="title" type="text">
        <input id="content" type="text">
        <select id="selectedCategory">
        <option value="">--Select a Category--</option>
            ${props.categories.map(category => `<option value=${category.id}>${category.name}</option>`)}
        </select>
        <button id="create-post-btn" type="button">Add Post</button>
        
    </form>
        <div>
            ${getPostsComponent(props.posts)}
        </div>
    </main>
    `;
}

function getPostsComponent(posts){
   return posts.map(post => `
                  <div class="post" style="margin-top: 10px">
                        
                        <input class="edit-title"  value="${post.title}" readonly>
                        <input class="edit-content" value="${post.content}" readonly>
                        <h4 class="username"> posted by: ${post.user.username}</h4>
                        <div class="categories">
                            ${getCategoriesComponent(post.categories)}
                        </div>
                        <button class="edit-btn" data-id="${post.id}">Edit</button>
                        <button class="delete-btn" data-id="${post.id}">Delete</button>
                        <br>
                </div>
            `).join('')
}

function getCategoriesComponent(categories){
    console.log(categories)
    return categories.map(category =>
        `
            <span>#${category.name}</span>
        `
    ).join('');
}

export function PostEvents() {

    createEvent()
    editEvent()
    deleteEvent()


}

function createEvent() {
    $("#create-post-btn").click(function (){

        let post = {
            title : $("#title").val(),
            content : $("#content").val(),
            categories :[{id:$("#selectedCategory").val()}]
        }
        console.log(post)
        let request = {
            method: "POST",
            headers: getHeaders(),
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

        $(".edit-title, .edit-content").attr("readonly", true)

        $(this).siblings(".edit-title, .edit-content").attr("readonly", false);
        $(this).text("Save");



        $(this).on("click", submitEditEvent)

    })
}

function submitEditEvent(){
    let post = {
        title: $(this).siblings(".edit-title").val(),
        content: $(this).siblings(".edit-content").val()
    }

    let request = {
        method: "PUT",
        headers: getHeaders(),
        body: JSON.stringify(post)
    }

    console.log(post)

    $(this).off("click", submitEditEvent);

    let id = $(this).attr("data-id")

    fetch(`http://localhost:8080/api/posts/${id}`, request)
        .then(res => {
            console.log(res.status);
            createView("/posts")
        }).catch(error => {
        console.log(error);
        createView("/posts")
    });


}

function deleteEvent(){
    $(".delete-btn").click(function (){

        let request = {
            method: "DELETE",
            headers: getHeaders(),
        }

        let id = $(this).attr("data-id")

        fetch(`http://localhost:8080/api/posts/${id}`, request)
            .then(res => {
                console.log(res.status);
                createView("/posts");
            })
            .catch(error => {
                console.log(error)
                createView("/posts")
            })
    })
}




