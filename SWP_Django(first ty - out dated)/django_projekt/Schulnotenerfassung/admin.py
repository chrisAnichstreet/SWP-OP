from django.contrib import admin
from django.core.exceptions import ValidationError
from django.forms.models import BaseInlineFormSet
from django import forms


# Register your models here.
from .models import Schueler, Klasse, Lehrer, Faecher, Unterrichts_Fach, Noten

#-----------------------------------------------------------------------------------------


class SchuelerAdmin(admin.ModelAdmin):
    fieldsets = [
        ('Klasse',{'fields':['k_id']}),
        ('User',{'fields':['user']})
    ]

admin.site.register(Schueler, SchuelerAdmin)


#-----------------------------------------------------------------------------------------

class deleteFormSet(BaseInlineFormSet):
    def delete_existing(self, obj, commit=True):
        if commit:
            obj.k_id=None
            obj.save()
            obj.noten_set.all().delete()


class SchuelerInLine(admin.TabularInline):
    model = Schueler
    extra=3
    formset=deleteFormSet


class KlasseAdmin(admin.ModelAdmin):
    fieldsets = [
       ('Klasse-Informationen', {'fields': ['jahrgang','name']}),
    ]
    inlines = [SchuelerInLine,]

    list_filter = ['jahrgang','name']
    search_fields = ['jahrgang','name']

admin.site.register(Klasse, KlasseAdmin)


#-----------------------------------------------------------------------------------------
'''


class LehrerAdmin(admin.ModelAdmin):
    fieldsets = [
        ('Lehrer-Informationen', {'fields': ['first_name','last_name']}),
        ('Anmeldeinformationen', {'fields': ['email','password']})
    ]

    list_display = ('first_name','last_name','email')
    search_fields = ['first_name','last_name','email']

admin.site.register(Lehrer, LehrerAdmin)


'''

#-----------------------------------------------------------------------------------------

class FaecherAdmin(admin.ModelAdmin):
    fieldsets = [
        ('Fach-Informationen', {'fields': ['fach_name']}),
    ]

    list_display = ('fach_name',)
    search_fields = ['fach_name']

admin.site.register(Faecher, FaecherAdmin)



#-----------------------------------------------------------------------------------------



class UnterrichtsFachAdmin(admin.ModelAdmin):
    fieldsets = [
        ('UnterrichtsFach-Informationen', {'fields': ['f_id','l_id','k_id']}),
    ]

    list_display = ('f_id','l_id','k_id')
    list_filter = ['f_id','l_id','k_id']
    search_fields = ['f_id__fach_name','l_id__first_name','l_id__last_name','k_id__name','k_id__jahrgang']

admin.site.register(Unterrichts_Fach, UnterrichtsFachAdmin)




#-----------------------------------------------------------------------------------------

class NotenForm(forms.ModelForm):
    class Meta:
        model = Noten
        fields = '__all__'
   
    def clean(self):
        note = self.cleaned_data.get('note')
        s = self.cleaned_data.get('s_id')
        u = self.cleaned_data.get('u_id')

        equal = (s.k_id == u.k_id) and note > 0 and note < 6

        if equal:
            super(NotenForm, self).clean()
        else:
            raise ValidationError("Der Schüler befindet sich nicht in der Klasse des UnterrichtsFaches oder es wurde eine Note die nicht 1 - 5 ist angegeben")
            

class NotenAdmin(admin.ModelAdmin):
    fieldsets = [
        ('Noten-Informationen', {'fields': ['note','s_id','u_id']}),
    ]
    form = NotenForm
    
    list_display = ('note','s_id','u_id')
    list_filter = ['u_id__k_id__jahrgang','u_id__k_id__name','u_id__f_id__fach_name']
    search_fields = ['note','s_id__first_name','s_id__last_name','u_id__k_id__name','u_id__k_id__jahrgang','u_id__k_id__name','u_id__f_id__fach_name','u_id__l_id__last_name','u_id__l_id__first_name']
admin.site.register(Noten, NotenAdmin)