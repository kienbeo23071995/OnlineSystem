
import java.util.Arrays;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import utils.RoleAndRequestMapper;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/ServletListener.java to edit this template
 */
/**
 * Web application lifecycle listener.
 *
 * @author tiendang
 */
import model.Role.Type;

public class ApplicationServletContext implements ServletContextListener {

    protected RoleAndRequestMapper roleAndRequestMapper = new RoleAndRequestMapper();

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        registerResourcePage();
    }

    public void registerResourcePage() {
        //Insert .jsp or Servlet mapping here NOTE: (Without slash /)!!!!
        //Dasboard 
        roleAndRequestMapper.register("system/DashboardServlet", Arrays.asList(Type.admin));
        roleAndRequestMapper.register("adminDashboard.jsp", Arrays.asList(Type.admin));

        //Slider 
        roleAndRequestMapper.register("system/add-slider", Arrays.asList(Type.admin, Type.marketing));
        roleAndRequestMapper.register("system/edit-slider", Arrays.asList(Type.admin, Type.marketing));
        roleAndRequestMapper.register("system/hide-slider", Arrays.asList(Type.admin, Type.marketing));
        roleAndRequestMapper.register("system/show-slider", Arrays.asList(Type.admin, Type.marketing));
        roleAndRequestMapper.register("system/search-slider", Arrays.asList(Type.admin, Type.marketing));
        roleAndRequestMapper.register("system/slider-list", Arrays.asList(Type.admin, Type.marketing));
        roleAndRequestMapper.register("system/slider-detail", Arrays.asList(Type.admin, Type.marketing));

        roleAndRequestMapper.register("system/AddNewSlider.jsp", Arrays.asList(Type.admin, Type.sale));
        roleAndRequestMapper.register("system/EditSlider.jsp", Arrays.asList(Type.admin, Type.sale));
        roleAndRequestMapper.register("system/SliderDetail.jsp", Arrays.asList(Type.admin, Type.sale));
        roleAndRequestMapper.register("system/SliderList.jsp", Arrays.asList(Type.admin, Type.sale));

        //Lesson
        roleAndRequestMapper.register("system/AddLessonServlet", Arrays.asList(Type.admin, Type.expert));
        roleAndRequestMapper.register("system/subject-lesson", Arrays.asList(Type.admin, Type.expert));
        roleAndRequestMapper.register("system/subject-lesson-detail", Arrays.asList(Type.admin, Type.expert));
        roleAndRequestMapper.register("system/ViewAddLessonServlet", Arrays.asList(Type.admin, Type.expert));
        roleAndRequestMapper.register("system/ViewLessonDetailServlet", Arrays.asList(Type.admin, Type.expert));
        roleAndRequestMapper.register("system/filter-lesson", Arrays.asList(Type.admin, Type.expert));

        roleAndRequestMapper.register("system/addLesson.jsp", Arrays.asList(Type.admin, Type.expert));
        roleAndRequestMapper.register("system/SubjectLesson.jsp", Arrays.asList(Type.admin, Type.expert));

        //User
        roleAndRequestMapper.register("system/UserList", Arrays.asList(Type.admin));
        roleAndRequestMapper.register("system/UserDetail", Arrays.asList(Type.admin));
        roleAndRequestMapper.register("system/FilterUser", Arrays.asList(Type.admin));

        roleAndRequestMapper.register("system/UserList.jsp", Arrays.asList(Type.admin));
        roleAndRequestMapper.register("system/UserDetail.jsp", Arrays.asList(Type.admin));

        //Quizzes
        roleAndRequestMapper.register("system/add-quiz", Arrays.asList(Type.admin, Type.expert));
        roleAndRequestMapper.register("system/edit-quiz-async", Arrays.asList(Type.admin, Type.expert));
        roleAndRequestMapper.register("system/edit-quiz", Arrays.asList(Type.admin, Type.expert));
        roleAndRequestMapper.register("system/hide-quiz", Arrays.asList(Type.admin, Type.expert));
        roleAndRequestMapper.register("system/quiz-detail", Arrays.asList(Type.admin, Type.expert));
        roleAndRequestMapper.register("system/quiz-list", Arrays.asList(Type.admin, Type.expert));
        roleAndRequestMapper.register("system/show-quiz", Arrays.asList(Type.admin, Type.expert));

        roleAndRequestMapper.register("system/QuizList.jsp", Arrays.asList(Type.admin, Type.expert));
        roleAndRequestMapper.register("system/ListLessons.jsp", Arrays.asList(Type.admin, Type.expert));
        roleAndRequestMapper.register("system/QuizDetail.jsp", Arrays.asList(Type.admin, Type.expert));

        roleAndRequestMapper.register("system/DoQuizzServlet", Arrays.asList(Type.admin, Type.expert, Type.customer));
        roleAndRequestMapper.register("system/PracticeQuizzServlet", Arrays.asList(Type.admin, Type.expert, Type.customer));
        roleAndRequestMapper.register("system/ReviewQuizzServlet", Arrays.asList(Type.admin, Type.expert, Type.customer));
        roleAndRequestMapper.register("system/QuizDetailReview", Arrays.asList(Type.admin, Type.expert, Type.customer));
        roleAndRequestMapper.register("system/SearchQuizController", Arrays.asList(Type.admin, Type.expert, Type.customer));
        roleAndRequestMapper.register("system/simulation-exam", Arrays.asList(Type.admin, Type.expert, Type.customer));

        roleAndRequestMapper.register("system/doQuizz.jsp", Arrays.asList(Type.admin, Type.expert, Type.customer));
        roleAndRequestMapper.register("system/QuizDetailReview.jsp", Arrays.asList(Type.admin, Type.expert, Type.customer));
        roleAndRequestMapper.register("system/reviewQuizz.jsp", Arrays.asList(Type.admin, Type.expert, Type.customer));
        roleAndRequestMapper.register("system/SimulationExam.jsp", Arrays.asList(Type.admin, Type.expert, Type.customer));

        //Question
        roleAndRequestMapper.register("system/delete-question", Arrays.asList(Type.admin, Type.expert));
        roleAndRequestMapper.register("system/FilterQuestion", Arrays.asList(Type.admin, Type.expert));
        roleAndRequestMapper.register("system/InsertQuestion", Arrays.asList(Type.admin, Type.expert));
        roleAndRequestMapper.register("system/question-detail", Arrays.asList(Type.admin, Type.expert));
        roleAndRequestMapper.register("system/QuestionListAdminServlet", Arrays.asList(Type.admin, Type.expert));
        roleAndRequestMapper.register("system/QuestionList", Arrays.asList(Type.admin, Type.expert));
        roleAndRequestMapper.register("system/search-question", Arrays.asList(Type.admin, Type.expert));
        roleAndRequestMapper.register("system/updateQuestion", Arrays.asList(Type.admin, Type.expert));

        roleAndRequestMapper.register("system/QuestionList.jsp", Arrays.asList(Type.admin, Type.expert));
        roleAndRequestMapper.register("system/QuestionListAdmin.jsp", Arrays.asList(Type.admin, Type.expert));
        roleAndRequestMapper.register("system/questionDetail.jsp", Arrays.asList(Type.admin, Type.expert));

        //Subject done
        roleAndRequestMapper.register("system/CreateController", Arrays.asList(Type.admin, Type.expert));
        roleAndRequestMapper.register("system/CreateFormController", Arrays.asList(Type.admin, Type.expert));
        roleAndRequestMapper.register("system/EditSubjectController", Arrays.asList(Type.admin, Type.expert));
        roleAndRequestMapper.register("system/SubjectListAdmin", Arrays.asList(Type.admin, Type.expert));
        roleAndRequestMapper.register("system/SubjectDetailAdminController", Arrays.asList(Type.admin, Type.expert));
        roleAndRequestMapper.register("system/UpdateController", Arrays.asList(Type.admin, Type.expert));

        roleAndRequestMapper.register("system/CreateSubject.jsp", Arrays.asList(Type.admin, Type.expert));
        roleAndRequestMapper.register("system/Detail.jsp", Arrays.asList(Type.admin, Type.expert));
        roleAndRequestMapper.register("system/SubjectListAdmin.jsp", Arrays.asList(Type.admin, Type.expert));
//        roleAndRequestMapper.register("system/SubjectDetail.jsp", Arrays.asList(Type.admin, Type.expert));

        //Dimensions Coursecontent done
        roleAndRequestMapper.register("system/CreateDimension", Arrays.asList(Type.admin, Type.expert));
        roleAndRequestMapper.register("system/DeleteDimension", Arrays.asList(Type.admin, Type.expert));
        roleAndRequestMapper.register("system/EditDimension", Arrays.asList(Type.admin, Type.expert));
        roleAndRequestMapper.register("system/delete-dimension", Arrays.asList(Type.admin, Type.expert));
        roleAndRequestMapper.register("system/dimension-list", Arrays.asList(Type.admin, Type.expert));
        roleAndRequestMapper.register("system/update-dimension", Arrays.asList(Type.admin, Type.expert));
        roleAndRequestMapper.register("system/update_dimension-async", Arrays.asList(Type.admin, Type.expert));

        roleAndRequestMapper.register("system/CreateDimension.jsp", Arrays.asList(Type.admin, Type.expert));
        roleAndRequestMapper.register("system/EditDimension.jsp", Arrays.asList(Type.admin, Type.expert));
        roleAndRequestMapper.register("system/DimensionCreate.jsp", Arrays.asList(Type.admin, Type.expert));
        roleAndRequestMapper.register("system/DimensionAndPackage.jsp", Arrays.asList(Type.admin, Type.expert));
        roleAndRequestMapper.register("system/UpdateDimensionAsync.jsp", Arrays.asList(Type.admin, Type.expert));

        //Package Price 
        roleAndRequestMapper.register("system/AddPackageInSubject", Arrays.asList(Type.admin));
        roleAndRequestMapper.register("system/DeletePackageInSubject", Arrays.asList(Type.admin));
        roleAndRequestMapper.register("system/update_price_async", Arrays.asList(Type.admin));
        roleAndRequestMapper.register("system/PricePackageUpdateInSubject", Arrays.asList(Type.admin));

        roleAndRequestMapper.register("system/AddPackagePriceInSubject.jsp", Arrays.asList(Type.admin));
        roleAndRequestMapper.register("system/InforPackagePrice.jsp", Arrays.asList(Type.admin));
        roleAndRequestMapper.register("system/EditPricePackage.jsp", Arrays.asList(Type.admin));

        //Post Detail
        roleAndRequestMapper.register("system/add-post", Arrays.asList(Type.admin, Type.marketing));
        roleAndRequestMapper.register("system/edit-post", Arrays.asList(Type.admin, Type.marketing));
        roleAndRequestMapper.register("system/post-detail", Arrays.asList(Type.admin, Type.marketing, Type.customer));
        roleAndRequestMapper.register("system/post-list", Arrays.asList(Type.admin, Type.marketing, Type.customer));
        roleAndRequestMapper.register("system/testEdit", Arrays.asList(Type.admin, Type.marketing));

        roleAndRequestMapper.register("system/AddNewPost.jsp", Arrays.asList(Type.admin, Type.marketing));
        roleAndRequestMapper.register("system/EditPost.jsp", Arrays.asList(Type.admin, Type.marketing));
        roleAndRequestMapper.register("system/PostDetail.jsp", Arrays.asList(Type.admin, Type.marketing, Type.customer));
        roleAndRequestMapper.register("system/BlogList.jsp", Arrays.asList(Type.admin, Type.marketing, Type.customer));

        //Practice done
        roleAndRequestMapper.register("system/filter-practice-async", Arrays.asList(Type.customer));
        roleAndRequestMapper.register("system/practice-list", Arrays.asList(Type.customer));
        roleAndRequestMapper.register("system/practiceQuiz", Arrays.asList(Type.customer));
        roleAndRequestMapper.register("system/PraticeDetail", Arrays.asList(Type.customer));

        roleAndRequestMapper.register("system/PracticeListAsync.jsp", Arrays.asList(Type.customer));
        roleAndRequestMapper.register("system/PracticeList.jsp", Arrays.asList(Type.customer));
        roleAndRequestMapper.register("system/PracticeDetail.jsp", Arrays.asList(Type.customer));

        //PricePackage done
        roleAndRequestMapper.register("system/create-pricePackage", Arrays.asList(Type.admin));
        roleAndRequestMapper.register("system/delete-pricePackage", Arrays.asList(Type.admin));
        roleAndRequestMapper.register("system/update-pricePackage", Arrays.asList(Type.admin));

        roleAndRequestMapper.register("system/PricePackageCreate.jsp", Arrays.asList(Type.admin));
        roleAndRequestMapper.register("system/PricePackageUpdate.jsp", Arrays.asList(Type.admin));

        //Question done
        roleAndRequestMapper.register("system/delete-question", Arrays.asList(Type.admin, Type.expert));
        roleAndRequestMapper.register("system/FilterQuestion", Arrays.asList(Type.admin, Type.expert));
        roleAndRequestMapper.register("system/InsertQuestion", Arrays.asList(Type.admin, Type.expert));
        roleAndRequestMapper.register("system/QuestionListAdminServlet", Arrays.asList(Type.admin, Type.expert));
        roleAndRequestMapper.register("system/QuestionList", Arrays.asList(Type.admin, Type.expert));
        roleAndRequestMapper.register("system/updateQuestion", Arrays.asList(Type.admin, Type.expert));

        roleAndRequestMapper.register("system/QuestionList.jsp", Arrays.asList(Type.admin, Type.expert));
        roleAndRequestMapper.register("system/questionDetail.jsp", Arrays.asList(Type.admin, Type.expert));
        roleAndRequestMapper.register("system/QuestionListAdmin.jsp", Arrays.asList(Type.admin, Type.expert));

        //Registration done
        roleAndRequestMapper.register("system/edit-status-regis", Arrays.asList(Type.admin, Type.sale));
        roleAndRequestMapper.register("system/filter-registration", Arrays.asList(Type.admin, Type.sale));
        roleAndRequestMapper.register("system/regis-list", Arrays.asList(Type.admin, Type.sale));

        roleAndRequestMapper.register("system/RegistrationList.jsp", Arrays.asList(Type.admin, Type.sale));

        //(slider,lesson,user ,quizzes,question,su+bject,Dimensions Course,Package price ,Post,Practices,PricePackage,Question,Registration )
        

//        roleAndRequestMapper.register("system/normal-lession.jsp", Arrays.asList(Type.admin, Type.customer, Type.expert, Type.marketing, Type.sale));
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

}
