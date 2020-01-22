from django.db import models
from django.contrib.auth.models import User

# Create your models here.

class Klasse(models.Model):
    k_id = models.AutoField(primary_key=True)
    jahrgang = models.IntegerField(null=False, verbose_name="Jahrgang")
    name = models.CharField(max_length= 200,null=False, verbose_name="Klassen Bezeichnung")

    class Meta:
        unique_together = (('jahrgang', 'name'),)
        verbose_name = 'Klasse'
        verbose_name_plural = 'Klasse'

    def __str__(self):
        return str(self.jahrgang) + self.name



class Schueler (models.Model):
    s_id = models.AutoField(primary_key=True)
    k_id = models.ForeignKey(Klasse,on_delete=models.SET_NULL, null=True, blank=True, verbose_name="Klasse")
    user = models.ForeignKey(User,on_delete=models.CASCADE, null=True)
    
    class Meta:
        verbose_name = 'Schueler'
        verbose_name_plural = 'Schueler'

   



class Lehrer(models.Model):
    l_id = models.AutoField(primary_key=True)
    user = models.ForeignKey(User, on_delete=models.CASCADE, null=False)

    class Meta:
       verbose_name = 'Lehrer'
       verbose_name_plural = 'Lehrer'

    def __str__(self):
        return self.first_name + " " + self.last_name

class Faecher(models.Model):
    f_id = models.AutoField(primary_key=True)
    fach_name = models.CharField(max_length = 200, null=False, unique=True, verbose_name="Fach Bezeichnung")

    class Meta:
       verbose_name = 'Fach'
       verbose_name_plural = 'Faecher'

    def __str__(self):
        return self.fach_name

class Unterrichts_Fach(models.Model):
    f_id = models.ForeignKey(Faecher, on_delete=models.CASCADE, verbose_name="Fach")
    l_id = models.ForeignKey(Lehrer, on_delete= models.CASCADE, verbose_name="Lehrer")
    k_id = models.ForeignKey(Klasse, on_delete=models.CASCADE, verbose_name="Klasse")

    class Meta:
        unique_together = (('f_id', 'l_id','k_id'),)
        verbose_name = 'Unterrichts Fach'
        verbose_name_plural = 'Unterrichts Faecher'

    def __str__(self):
        return str(self.f_id) + " " + str(self.l_id) + " " + str(self.k_id)

class Noten(models.Model):
    s_id = models.ForeignKey(Schueler, on_delete=models.CASCADE, verbose_name="Schueler")
    u_id = models.ForeignKey(Unterrichts_Fach, on_delete=models.CASCADE, null=True, verbose_name="Unterrichts Fach")
    note = models.IntegerField(null=False, default=0) 

    class Meta:
        unique_together = (('s_id', 'u_id'),)
        verbose_name = 'Note'
        verbose_name_plural = 'Noten'

    def __str__(self):
        return str(self.s_id) + " " + str(self.u_id)