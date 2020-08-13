

//var provider = new firebase.auth.GoogleAuthProvider();

function init()
{
const firebaseConfig = {
  apiKey: "AIzaSyBEzhlpzcJ1lxjfTBo_2ZMy2ZCxyz91AZY",
  authDomain: "bball-auth.firebaseapp.com",
  databaseURL: "https://bball-auth.firebaseio.com",
  projectId: "bball-auth",
  storageBucket: "bball-auth.appspot.com",
  messagingSenderId: "683174093253",
  appId: "1:683174093253:web:4147805c827ef462a42bac",
  measurementId: "G-HPR7E8QF8E"

};
// Initialize Firebase

var defaultProject = firebase.initializeApp(firebaseConfig);
  // "[DEFAULT]"*/

if (!firebase.apps.length){ return;}

var uiConfig = {
  callbacks: {
    signInSuccessWithAuthResult: function(authResult, redirectUrl) {
      // User successfully signed in.
      // Return type determines whether we continue the redirect automatically
      // or whether we leave that to developer to handle.
	
      return true;
    },
    uiShown: function() {
      // The widget is rendered.
      // Hide the loader.
      document.getElementById('loader').style.display = 'none';
    }
  },
  // Will use popup for IDP Providers sign-in flow instead of the default, redirect.
  signInFlow: 'popup',
  signInSuccessUrl: 'loginSuccess.html',
  signInOptions: [
    // Leave the lines as is for the providers you want to offer your users.
    firebase.auth.GoogleAuthProvider.PROVIDER_ID,
    firebase.auth.FacebookAuthProvider.PROVIDER_ID,
    firebase.auth.TwitterAuthProvider.PROVIDER_ID,
    firebase.auth.GithubAuthProvider.PROVIDER_ID,
    firebase.auth.EmailAuthProvider.PROVIDER_ID,
    firebase.auth.PhoneAuthProvider.PROVIDER_ID
  ],
  // Terms of service url.
  tosUrl: '<your-tos-url>',
  // Privacy policy url.
  privacyPolicyUrl: '<your-privacy-policy-url>'
};
var ui = new firebaseui.auth.AuthUI(firebase.auth());
if (! ui.isPendingRedirect()) {
  ui.start('#firebaseui-auth-container', uiConfig);
}
}

function init2()
{
const firebaseConfig = {
  apiKey: "AIzaSyBEzhlpzcJ1lxjfTBo_2ZMy2ZCxyz91AZY",
  authDomain: "bball-auth.firebaseapp.com",
  databaseURL: "https://bball-auth.firebaseio.com",
  projectId: "bball-auth",
  storageBucket: "bball-auth.appspot.com",
  messagingSenderId: "683174093253",
  appId: "1:683174093253:web:4147805c827ef462a42bac",
  measurementId: "G-HPR7E8QF8E"

};
// Initialize Firebase

firebase.initializeApp(firebaseConfig);
alert("here");
firebase.auth().onAuthStateChanged(function(user) {
    if (user) {
      alert("Signed in user!")
    } else {
      alert("No user!")
    }
  });




  // "[DEFAULT]"*/
/*
if (!firebase.apps.length){ return;}

var uiConfig = {
  callbacks: {
    signInSuccessWithAuthResult: function(authResult, redirectUrl) {
      // User successfully signed in.
      // Return type determines whether we continue the redirect automatically
      // or whether we leave that to developer to handle.
	
      return true;
    },
    uiShown: function() {
      // The widget is rendered.
      // Hide the loader.
      document.getElementById('loader').style.display = 'none';
    }
  },
  // Will use popup for IDP Providers sign-in flow instead of the default, redirect.
  signInFlow: 'popup',
  signInSuccessUrl: 'loginSuccess.html',
  signInOptions: [
    // Leave the lines as is for the providers you want to offer your users.
    firebase.auth.GoogleAuthProvider.PROVIDER_ID,
    firebase.auth.FacebookAuthProvider.PROVIDER_ID,
    firebase.auth.TwitterAuthProvider.PROVIDER_ID,
    firebase.auth.GithubAuthProvider.PROVIDER_ID,
    firebase.auth.EmailAuthProvider.PROVIDER_ID,
    firebase.auth.PhoneAuthProvider.PROVIDER_ID
  ],
  // Terms of service url.
  tosUrl: '<your-tos-url>',
  // Privacy policy url.
  privacyPolicyUrl: '<your-privacy-policy-url>'
};
var ui = new firebaseui.auth.AuthUI(firebase.auth());
if (! ui.isPendingRedirect()) {
  ui.start('#firebaseui-auth-container', uiConfig);
}

window.cst = firebase.auth();*/


}


function userInfo()
{/*
	var user = window.cst.currentUser;

if (user != null) {
  user.providerData.forEach(function (profile) {
    alert("Sign-in provider: " + profile.providerId);
    alert("  Provider-specific UID: " + profile.uid);
    alert("  Name: " + profile.displayName);
    alert("  Email: " + profile.email);
    alert("  Photo URL: " + profile.photoURL);
  });
}*/}



