from django.shortcuts import render
from django.contrib.auth import authenticate, login
from django.contrib.auth.decorators import login_required
from .models import Klasse




from .models import Schueler

# Create your views here.

#@login_required
def index(request):
    if not request.user.is_authenticated:
        if request.method == 'POST':
            username = request.POST.get('username')
            password = request.POST.get('password')
            user = authenticate(username=username,password=password)
            if user is not None:
                login(request,user)
                context = {'user':user}
                return render(request,'Schulnotenerfassung/test.html',context)
            else:
                return render(request,'Schulnotenerfassung/index.html')
        else:
            return render(request,'Schulnotenerfassung/index.html')
    else:
        return render(request,'Schulnotenerfassung/test.html')




def Lehrer(request):
    rap = Klasse.objects.all()
    context = {'rap': rap}
    return render(request, 'Schulnotenerfassung /Lehrer.html', context)

