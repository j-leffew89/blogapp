export default function Login(props) {
    return `<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Log In</title>
</head>
<body>

<h1 style="font-family: cursive; text-align-last: center">Login</h1>

<form id="login-form" style="text-align-last: center; font-family: cursive; white-space: break-spaces">
<!--    <label for="username">Username</label>-->
    <input id="email" name="email" type="text" placeholder="Email"/>
<!--    <label for="password">Password</label>-->
    <input id="password" name="password" type="password" placeholder="Password"/>
    
    <label><input type="checkbox" id="Remember_me" value="windows"> Remember Me</label>

    <input id="login-btn" type="submit" value="Log In" style="margin-top: 10px"/>
    

</form>
</body>
</html>`;
}

