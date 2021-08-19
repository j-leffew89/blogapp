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
            ${getPostsComponent(props.posts)}
        </div>
    </main>
    `;
}

function getPostsComponent(posts){
   return posts.map(post => `
                  <div class="post">
                         <h2>${post.user.username}</h2>
                        <input class="edit-title"  value="${post.title}" readonly>
                        <input class="edit-content" value="${post.content}" readonly>
                        <h4 class="username"> posted by: ${post.user.username}</h4>
                        <div class="categories">
                            ${getCategoriesComponent(post.categories)}
                        </div>
                        <button class="edit-btn" data-id="${post.id}">Edit</button>
                        <button class="delete-btn" data-id="${post.id}">Delete</button>
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
            content : $("#content").val()
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
        headers: {
            "Content-Type": "application/json"
        },
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
            headers: {"Content-Type": "application/json"},
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




