<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Log In</title>
  <style>
    /* Basic styles */
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
    }

    .container {
      display: flex;
      justify-content: center;
      align-items: center;
      min-height: 100vh;
    }

    .login-container {
      background-color: #f0f0f0;
      padding: 40px;
      border-radius: 5px;
      width: 300px;
    }

    h2 {
      text-align: center;
      margin-bottom: 20px;
    }

    /* Login form styles */
    form {
      display: flex;
      flex-direction: column;
    }

    .input-div {
      margin-bottom: 15px;
      display: flex;
    }

    .i {
      width: 50px;
      text-align: center;
      line-height: 50px;
    }

    .i i {
      font-size: 20px;
      color: #ccc;
    }

    .input {
      padding: 10px;
      border: 1px solid #ccc;
      border-radius: 3px;
      flex: 1;
    }

    .btn {
      background-color: #333;
      color: #fff;
      padding: 10px 15px;
      border: none;
      border-radius: 3px;
      cursor: pointer;
      margin-top: 20px;
    }

    .forgot {
      text-align: center;
      margin-top: 10px;
      color: #ccc;
    }

    .account {
      text-align: center;
      margin-top: 20px;
    }

    .account a {
      color: #333;
      text-decoration: none;
    }
  </style>
</head>

<body>
  <div class="container">
    <div class="login-container">
      <form action="Login">
        <h2>Log In</h2>
        <div class="input-div">
          <div class="i">
            <i class="fas fa-user"></i>
          </div>
          <div>
            <input class="input" type="text" name="email" placeholder="Username or Email">
          </div>
        </div>
        <div class="input-div">
          <div class="i">
            <i class="fas fa-key"></i>
          </div>
          <div>
            <input class="input" type="password" name="password" placeholder="Password">
          </div>
        </div>
        <input type="submit" class="btn" value="Log In">
        <div class="account">
          <p>Don't have an account yet?</p>
          <a href="registration.jsp">Sign Up</a>
        </div>
      </form>
    </div>
  </div>
</body>

</html>
