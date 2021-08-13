// Create
fetch("http://localhost:8080/api/posts", {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json'
    },
    redirect: 'follow',
    body: JSON.stringify([
            {

            }
        ]
    )
}).then(function(response) {
    return response.json();
}).then(function(data) {
    console.log(data);
});

// Read

fetch("http://localhost:8080/api/posts", {
    method: 'GET',
    headers: {
        'Content-Type': 'application/json'
    },
    redirect: 'follow'
}).then(function(response) {
    return response.json();
}).then(function(data) {
    console.log(data);
});

// Update

fetch("http://localhost:8080/api/posts", {
    method: 'PUT',
    headers: {
        'Content-Type': 'application/json'
    },
    redirect: 'follow',
    body: JSON.stringify({

    })
}).then(function(response) {
    return response.json();
}).then(function(data) {
    console.log(data);
});


// Delete

fetch("http://localhost:8080/api/posts", {
    method: 'DELETE',
    headers: {
        'Content-Type': 'application/json'
    },
    redirect: 'follow',
    body: JSON.stringify(8)
}).then(function(response) {
    return response.json();
}).then(function(data) {
    console.log(data);
});