from django.contrib import admin
from django.core.exceptions import ValidationError
from django.forms.models import BaseInlineFormSet
from django import forms
from django.contrib.auth.admin import UserAdmin
from django.contrib.auth.forms import UserChangeForm


# Register your models here.
from .models import Klasse, Faecher, Unterrichts_Fach, Noten, User, Schueler2, Lehrer2, User, Admin


#-----------------------------------------------------------------------------------------
class Schueler2ChangeForm(UserChangeForm):
    class Meta(UserChangeForm.Meta):
        model = Schueler2

    def clean(self):
        username = self.cleaned_data.get('username')
        k_id = self.cleaned_data.get('k_id')
        id = Schueler2.objects.get(username=username).id

        noten = Noten.objects.filter(s_id=id)

        for note in noten:
            if not note.u_id.k_id == k_id:
                noten.delete()
                return
        super(Schueler2ChangeForm, self).clean()

        

class Schueler2Admin(UserAdmin):
    form = Schueler2ChangeForm

    fieldsets = [
       ('Schueler', {'fields': ['k_id','last_name','first_name','email','password','username']}),
    ]

    list_filter = []
    list_display = ('username','email','first_name','last_name','k_id')
    search_fields = ['username','email','first_name','last_name','k_id__name','k_id__jahrgang']

admin.site.register(Schueler2, Schueler2Admin)


#-----------------------------------------------------------------------------------------

class deleteFormSet(BaseInlineFormSet):
    def delete_existing(self, obj, commit=True):
        if commit:
            obj.k_id=None
            obj.save()
            obj.noten_set.all().delete()


class SchuelerInLine(admin.TabularInline):
    model = Schueler2
    formset=deleteFormSet
    fields =['username','email','first_name','last_name']
    element_set = forms.ModelMultipleChoiceField(queryset=Schueler2.objects.all())

    def has_add_permission(self, request):
        return False


class KlasseAdmin(admin.ModelAdmin):
    fieldsets = [
       ('Klasse-Informationen', {'fields': ['jahrgang','name']}),
    ]
    inlines = [SchuelerInLine,]

    list_filter = ['jahrgang','name']
    search_fields = ['jahrgang','name']

admin.site.register(Klasse, KlasseAdmin)


#-----------------------------------------------------------------------------------------

class Lehrer2ChangeForm(UserChangeForm):
    class Meta(UserChangeForm.Meta):
        model = Lehrer2


class Lehrer2Admin(UserAdmin):
    form = Lehrer2ChangeForm

    fieldsets = [
       ('Lehrer', {'fields': ['last_name','first_name','email','password','username']}),
    ]

    list_filter = []
    list_display = ('username','email','first_name','last_name')
    search_fields = ['username','email','first_name','last_name']

admin.site.register(Lehrer2, Lehrer2Admin)



#-----------------------------------------------------------------------------------------



class AdminChangeForm(UserChangeForm):
    class Meta(UserChangeForm.Meta):
        model = Admin


class AdminAdmin(UserAdmin):
    def save_model(self, request, obj, form, change):
        obj.is_staff = True
        obj.is_superuser=True
        obj.save()

    form = AdminChangeForm

    fieldsets = [
       ('Admin', {'fields': ['last_name','first_name','email','password','username']}),
    ]

    list_filter = []
    list_display = ('username','email','first_name','last_name')
    search_fields = ['username','email','first_name','last_name']

admin.site.register(Admin, AdminAdmin)



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