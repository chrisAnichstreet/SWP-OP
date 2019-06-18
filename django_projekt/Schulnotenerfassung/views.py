from django.shortcuts import render, redirect, get_object_or_404
from django.contrib.auth import authenticate, login, logout


from .models import Lehrer2, Schueler2, User, Unterrichts_Fach, Klasse, Faecher, Noten

# Create your views here.

def index(request):
    if not request.user.is_authenticated:
        if request.method == 'POST':
            username = request.POST.get('username')
            password = request.POST.get('password')

            user = authenticate(username=username,password=password)
            if user is not None:
                login(request,user)
                return redirect('Schulnotenerfassung:index')
            else:
                return render(request,'Schulnotenerfassung/index.html')
        else:
            return render(request,'Schulnotenerfassung/index.html')
    else:
        if not request.user.is_superuser:
            print(request.user.id)

            try:
                print(request.user.id)
                schueler = Schueler2.objects.get(id=request.user.id)
            except Schueler2.DoesNotExist:
                schueler = None

            try:
                lehrer = Lehrer2.objects.get(id=request.user.id)
            except Lehrer2.DoesNotExist:
                lehrer = None

            if (schueler == None) and (not lehrer == None):
                return redirect('Schulnotenerfassung:lehrer')
            if (not schueler == None) and (lehrer == None):
                noten = schueler.noten_set.all()
                return render(request,'Schulnotenerfassung/schuelerIndex.html', {'schueler':schueler, 'noten':noten})
        else:
            return redirect('/admin/')

def mylogout(request):
    logout(request)
    return redirect('Schulnotenerfassung:index')


def lehrer(request):
    if request.user.is_authenticated:
        lehrer = Lehrer2.objects.get(pk=request.user.id) 
        if not lehrer == None:
            uf = Unterrichts_Fach.objects.filter(l_id=lehrer).values('k_id').distinct()    

            klassen = []
            for klasse in uf:
                klassen.append(Klasse.objects.get(pk=klasse.get('k_id')))

            return render(request,'Schulnotenerfassung/lehrerIndex.html', {'lehrer':lehrer, 'klassen':klassen})
        else:
            return redirect('Schulnotenerfassung:index')
    else:
        return redirect('Schulnotenerfassung:index')

def klassenansicht(request, klasse):
    if request.user.is_authenticated:
        lehrer = Lehrer2.objects.get(pk=request.user.id) 
        if not lehrer == None:
            uf = Unterrichts_Fach.objects.filter(l_id=lehrer, k_id=klasse)
            k = Klasse.objects.get(pk=klasse)
        
            faecher = []
            for klasse in uf:
                faecher.append(klasse.f_id)

            return render(request,'Schulnotenerfassung/lehrerKlasse.html', {'lehrer':lehrer, 'k':k, 'faecher':faecher})
        else:
            return redirect('Schulnotenerfassung:index')
    else:
        return redirect('Schulnotenerfassung:index')

def fachansicht(request, klasse, fach):
    if request.user.is_authenticated:
        lehrer = Lehrer2.objects.get(pk=request.user.id) 
        if not lehrer == None:
            k = Klasse.objects.get(pk=klasse)
            schueler = k.schueler2_set.all()
            f = Faecher.objects.get(pk=fach)
            uf = Unterrichts_Fach.objects.get(l_id=lehrer.id, k_id=klasse, f_id=fach)

            return render(request,'Schulnotenerfassung/lehrerKlasseFach.html', {'lehrer':lehrer, 'k':k, 'f':f, 'schueler':schueler, 'uf':uf})
        else:
            return redirect('Schulnotenerfassung:index')
    else:
        return redirect('Schulnotenerfassung:index')

def postala(request):
    print('RECEIVED REQUEST: ' + request.method)
    if request.method == 'POST':

        letter = request.body.decode('utf-8')
        print(letter)

        firstsplit=[]
        entry=[]
        list=[]
        uf = []
        schueler = []

        firstsplit= letter.split("&")
        firstsplit.pop()
        print("Ohne Token")
        print(firstsplit)

        for elements in firstsplit:
            entry.append(elements[:-2])

        print("Gekürzer POST")
        print(entry)

        print("Völlig zersägt")
        for elements in entry:
            tmp = elements.split("_")
            tmp.append(request.POST.get(elements))
            list.append(tmp)

        print(list)
        print("Länge der Liste")
        print(len(list))
        print("jetzt noch richtig verteilen:")

        
        for i in list:
            student = Schueler2.objects.filter(id = i[0]).first()
            lession = Unterrichts_Fach.objects.filter(id= i[1]).first()

            try:
                note = Noten.objects.get(s_id=student, u_id=lession)
            except Noten.DoesNotExist:
                note = None

            if note == None:
                q = Noten(s_id=student,u_id=lession,note=int(i[2]))
                q.save()
            else:
                note.note=int(i[2])
                note.save()

    
    return redirect('Schulnotenerfassung:lehrer')