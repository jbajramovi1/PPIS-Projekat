import {
  Dashboard
} from './views';
import { RegisterCR } from './views/Pages';
import { RegisterAI } from './views/Pages';
import { ViewCR } from './views/Pages';
import DefaultLayout from './containers/DefaultLayout';

// https://github.com/ReactTraining/react-router/tree/master/packages/react-router-config
const routes = [
  { path: '/', exact: true, name: 'Home', component: DefaultLayout },
  { path: '/dashboard', name: 'Dashboard', component: Dashboard },
  { path: '/registercr', name: 'RegisterChangeRequest', component: RegisterCR},
  { path: '/registerai', name: 'RegisterAvailibilityIssue', component: RegisterAI},
  { path: '/viewcr/:id', name: 'ViewChangeRequest', component: ViewCR}
];

export default routes;
