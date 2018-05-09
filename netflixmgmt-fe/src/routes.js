import {
  Dashboard
} from './views';
import { RegisterCR } from './views/Pages'; 
import DefaultLayout from './containers/DefaultLayout';

// https://github.com/ReactTraining/react-router/tree/master/packages/react-router-config
const routes = [
  { path: '/', exact: true, name: 'Home', component: DefaultLayout },
  { path: '/dashboard', name: 'Dashboard', component: Dashboard },
  { path: '/registercr', name: 'RegisterChangeRequest', component: RegisterCR}
];

export default routes;
