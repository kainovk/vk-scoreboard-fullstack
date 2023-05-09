import About from "../pages/About";
import AdminPage from "../pages/AdminPage";
import Tasks from "../pages/Tasks";
import StatisticsPage from "../pages/StatisticsPage";
import TaskIdPage from "../pages/TaskIdPage";


export const routes = [
    {path: '/admin-panel', element: <AdminPage/>},
    {path: '/tasks', element: <Tasks/>},
    {path: '/tasks/:id', element: <TaskIdPage/>},
    {path: '/statistics', element: <StatisticsPage/>},
    {path: '/about', element: <About/>},
]