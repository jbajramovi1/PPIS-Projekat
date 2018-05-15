export default {
  items: [
    {
      name: 'Dashboard',
      url: '/dashboard',
      icon: 'icon-speedometer',
      badge: {
        variant: 'info',
        text: 'NEW',
      },
    },
    {
      title: true,
      name: 'Main Menu',
      wrapper: {
        element: '',
        attributes: {},
      },
    },
    {
      name: 'Change requests',
      url: '/widgets',
      icon: 'icon-calculator',
      badge: {
        variant: 'info',
        text: '',
      },
    }
  ]
};
