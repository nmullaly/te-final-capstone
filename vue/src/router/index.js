import { createRouter as createRouter, createWebHistory } from 'vue-router'
import { useStore } from 'vuex'

// Import components
import HomeView from '../views/HomeView.vue';
import LoginView from '../views/LoginView.vue';
import LogoutView from '../views/LogoutView.vue';
import RegisterView from '../views/RegisterView.vue';
import ProfileView from '../views/ProfileView.vue';
import TestView from '../views/TestView.vue';
import MovieHomeView from '../views/MovieHomeView.vue';
import MovieView from '../views/MovieView.vue';
import Test2View from '../views/Test2View.vue';
import MovieReview from '../components/MovieReview.vue'

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */
const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView,
    meta: {
      //requiresAuth: true was the default.  Switching to false.  Talk to ben about this on Monday
      requiresAuth: false
    }
  },
  {
    path: "/login",
    name: "login",
    component: LoginView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/logout",
    name: "logout",
    component: LogoutView,
    meta: {
      requiresAuth: false
    }
    //I'm making this accessible through the profile page but not the home page -Addie
  },
  {
    path: "/register",
    name: "register",
    component: RegisterView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/profile/:id",
    name: "ProfileView",
    component: ProfileView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/test",
    name: "test",
    component: TestView
  },
  {
    path:"/test2",
    name: "test2",
    component: Test2View  },
  {
    path: "/movie",
    name: "MovieHome",
    component: MovieHomeView,
  },
  {
    path: "/movie/:id",
    name: "Movie",
    component: MovieView,
  },
  {
    path:"/MovieReview",
    name: "MovieReview",
    component:  MovieReview,
  },
];

// Create the router
const router = createRouter({
  history: createWebHistory(),
  routes: routes
});

router.beforeEach((to) => {

  // Get the Vuex store
  const store = useStore();

  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    return {name: "login"};
  }
  // Otherwise, do nothing and they'll go to their next destination
});

export default router;
