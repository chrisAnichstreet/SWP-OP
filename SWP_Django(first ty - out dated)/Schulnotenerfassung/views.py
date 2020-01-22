from django.shortcuts import render
from django.http import HttpResponse
from django.template import loader

from .models import Faecher
from .models import Lehrer


def index(request):
    latest_question_list = Faecher.objects.all()
    template = loader.get_template('Schulnotenerfassung/index.html')
    context = {
        'latest_question_list': latest_question_list,
    }
    return HttpResponse(template.render(context, request))

def lehreralle(request):

    template = loader.get_template('Schulnotenerfassung/lehreralle.html')
    lehrerlist = Lehrer.objects.all()
    context = {
        'latest_question_list': lehrerlist
    }
    return HttpResponse(template.render(context,request))
def Schueler(request):

    template = loader.get_template('Schulnotenerfassung/Schueler.html')

    return HttpResponse(template.render(request))