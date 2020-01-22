'''
from Schulnotenerfassung.models import Lehrer, Faecher, Klasse, Unterrichts_Fach, Schueler, Noten
l = Lehrer(12, 10,'Karl')
'''

from django.db import models
import datetime
from django.utils import timezone

class Lehrer(models.Model):
    l_id = models.IntegerField()
    first_name = models.CharField(max_length=200)
    last_name = models.CharField(max_length=200)
    email = models.CharField(max_length=200)
    password = models.CharField(max_length=200)

class Faecher(models.Model):
    f_id = models.IntegerField()
    fach_name = models.CharField(max_length = 200)

class Klasse(models.Model):
    k_id = models.IntegerField()
    jahrgang = models.CharField(max_length=200) #Date Field ???
    name = models.CharField(max_length= 200)

class Unterrichts_Fach(models.Model):
    f_id = models.ForeignKey(Faecher, on_delete=models.CASCADE)
    l_id = models.ForeignKey(Lehrer, on_delete= models.CASCADE)
    k_id = models.ForeignKey(Klasse, on_delete=models.CASCADE)

class Schueler (models.Model):
    s_id = models.IntegerField()
    first_name = models.CharField(max_length=200)
    last_name = models.CharField(max_length=200)
    email = models.CharField(max_length=200)
    password = models.CharField(max_length=200)

class Noten(models.Model):
    s_id = models.ForeignKey(Schueler, on_delete=models.CASCADE)
    l_id = models.ForeignKey(Lehrer, on_delete=models.CASCADE)
    f_id = models.ForeignKey(Faecher, on_delete=models.CASCADE)
    note = models.IntegerField(default=0)



