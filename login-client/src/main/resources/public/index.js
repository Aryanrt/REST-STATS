//import * as firebase from "firebase/app";
//import "firebase/auth";
// Import firebaseui module.
//import * as firebaseui from 'firebaseui'
// Import gcip-iap module.
//import * as ciap from 'gcip-iap';


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
alert(defaultProject.name);
console.log(defaultProject.name);  // "[DEFAULT]"*/


/*
firebase.auth().onAuthStateChanged(function(user) {
  if (user) {
    alert("in");
  } else {
    alert("out");
  }
});*/


// Initialize the FirebaseUI Widget using Firebase.



}


function githubSignin()
{
	
	var user = firebase.auth().currentUser;
	alert(user);
	var ui = new firebaseui.auth.AuthUI(firebase.auth());

	ui.start('#firebaseui-auth-container', {
  signInOptions: [     firebase.auth.GoogleAuthProvider.PROVIDER_ID,
    firebase.auth.FacebookAuthProvider.PROVIDER_ID,
    firebase.auth.TwitterAuthProvider.PROVIDER_ID,
    firebase.auth.GithubAuthProvider.PROVIDER_ID,
    firebase.auth.EmailAuthProvider.PROVIDER_ID,
    firebase.auth.PhoneAuthProvider.PROVIDER_ID,
    {
      provider: firebase.auth.EmailAuthProvider.PROVIDER_ID,
      signInMethod: firebase.auth.EmailAuthProvider.EMAIL_LINK_SIGN_IN_METHOD,
/*   	  provider: firebase.auth.GoogleAuthProvider.PROVIDER_ID,
      provider: firebase.auth.FacebookAuthProvider.PROVIDER_ID,
      provider: firebase.auth.TwitterAuthProvider.PROVIDER_ID,
      provider: firebase.auth.GithubAuthProvider.PROVIDER_ID,
      provider: firebase.auth.EmailAuthProvider.PROVIDER_ID,*/
      // Allow the user the ability to complete sign-in cross device,
      // including the mobile apps specified in the ActionCodeSettings
      // object below.
      forceSameDevice: false,
      // Used to define the optional firebase.auth.ActionCodeSettings if
      // additional state needs to be passed along request and whether to open
      // the link in a mobile app if it is installed.
      emailLinkSignIn: function() {
        return {
          // Additional state showPromo=1234 can be retrieved from URL on
          // sign-in completion in signInSuccess callback by checking
          // window.location.href.
          url: 'https://www.example.com/completeSignIn?showPromo=1234',
          // Custom FDL domain.
          dynamicLinkDomain: 'example.page.link',
          // Always true for email link sign-in.
          handleCodeInApp: true,
          // Whether to handle link in iOS app if installed.
          iOS: {
            bundleId: 'com.example.ios'
          },
          // Whether to handle link in Android app if opened in an Android
          // device.
          android: {
            packageName: 'com.example.android',
            installApp: true,
            minimumVersion: '12'
          }
        };
      }
    }
  ],
signInSuccess: function(currentUser, credential, redirectUrl) {
  const userId = currentUser.uid; 
  // Manually redirect.
  window.location.assign(`/users/${userId}`);
  // Do not automatically redirect.
  return false;
},
});


	

}