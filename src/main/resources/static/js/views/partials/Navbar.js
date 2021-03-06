export default function Navbar(props) {
    return `
        <div class="card-header" style="font-family: cursive;">
            <nav class="d-flex justify-content-around">
                <a href="/" data-link>Home</a>
                <a href="/posts" data-link>Posts</a>
                <a href="/about" data-link>About</a>
                <a href="/login" data-link>Login</a>
                <a href="/register" data-link>Register</a>
                <a href="/user" data-link>User</a>
            </nav>
        </div>
    `;
}