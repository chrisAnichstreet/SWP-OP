from django.urls import  path
from . import views

app_name='Schulnotenerfassung'

urlpatterns = [
    path('', views.index, name='index'),
    path('mylogout',views.mylogout,name='mylogout'),
    path('lehrer',views.lehrer,name='lehrer'),
    path('lehrer/<int:klasse>', views.klassenansicht, name='klassenansicht'),
    path('lehrer/<int:klasse>/<int:fach>', views.fachansicht, name='fachansicht'),
    path('postala', views.postala, name="postala")
]