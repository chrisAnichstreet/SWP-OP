from django.urls import path

from . import views

urlpatterns = [
    path('', views.index, name='index'),
    path('Schulnotenerfassung/lehreralle/', views.lehreralle, name= 'lehreralle'),
    path('Schulnotenerfassung/Schueler/', views.Schueler, name= 'Schueler'),
]